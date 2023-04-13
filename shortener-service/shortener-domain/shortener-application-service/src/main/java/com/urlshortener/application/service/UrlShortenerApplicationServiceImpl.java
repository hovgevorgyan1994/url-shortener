package com.urlshortener.application.service;

import static java.util.Objects.nonNull;

import com.urlshortener.application.service.cache.CacheClient;
import com.urlshortener.application.service.dto.ActualUrlResponse;
import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.application.service.exception.UrlException;
import com.urlshortener.application.service.mapper.ShortenerMapper;
import com.urlshortener.application.service.ports.input.UrlShortenerApplicationService;
import com.urlshortener.application.service.ports.output.CountryIdentifier;
import com.urlshortener.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.application.service.ports.output.UrlRepository;
import com.urlshortener.domain.UrlDomainService;
import com.urlshortener.domain.entity.Url;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlShortenerApplicationServiceImpl implements UrlShortenerApplicationService {
    private final ShortenerMapper shortenerMapper;
    private final UrlMessagePublisher messagePublisher;
    private final UrlRepository urlRepository;
    private final CountryIdentifier countryIdentifier;
    private final UrlDomainService urlDomainService;
    private final CacheClient cacheClient;
    @Value("${application.base.uri}")
    private String baseUri;

    @Override
    public Mono<UrlShortenedResponse> shorten(ShortenUrlCommand shortenUrlCommand) {
        return Mono.create(sink -> {
            var fromCache = cacheClient.responseFromCache(shortenUrlCommand.getUrl());
            if (nonNull(fromCache)) {
                sink.success(fromCache);
            } else {
                var response = saveAndReturn(shortenUrlCommand);
                cacheClient.put(shortenUrlCommand, response);
                sink.success(response);
            }
        });
    }

    @Override
    public Mono<ActualUrlResponse> getActualUrl(String urlId) {
        return Mono.create(sink -> {
            var fromCache = cacheClient.urlFromCache(urlId);
            if (nonNull(fromCache)) {
                sink.success(ActualUrlResponse.of(fromCache.getUrl()));
            } else {
                sink.success(ActualUrlResponse.of(urlRepository.actualUrl(urlId).getUrl()));
            }
        });
    }

    private UrlShortenedResponse saveAndReturn(ShortenUrlCommand shortenUrlCommand) {
        var persist = persist(shortenUrlCommand);
        cacheClient.put(persist);
        var response = shortenerMapper.urlToResponse(baseUri, persist);
        cacheClient.put(shortenUrlCommand, response);
        return response;
    }

    private Url persist(ShortenUrlCommand shortenUrlCommand) {
        var country = countryIdentifier.identify(shortenUrlCommand.getIpAddress());
        if (log.isInfoEnabled()) {
            log.info("Attempt from {} to shorten url: {}", country, shortenUrlCommand.getUrl());
        }

        var requestDetails = shortenerMapper.shortenCommandToRequestDetails(shortenUrlCommand, country);
        var url = shortenerMapper.shortenCommandToUrl(shortenUrlCommand);
        var shortenedEvent = urlDomainService.shorten(url, requestDetails);

        var savedUrl = urlRepository.persist(url);
        if (savedUrl == null) {
            if (log.isWarnEnabled()) {
                log.warn("Could not save url from request: {}", shortenUrlCommand);
            }
            throw new UrlException("Could not save url from request: " + shortenUrlCommand);
        }
        messagePublisher.publish(shortenedEvent);
        return savedUrl;
    }
}
