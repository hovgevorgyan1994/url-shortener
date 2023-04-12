package com.urlshortener.application.service;

import com.urlshortener.application.service.cache.IgniteCacheService;
import com.urlshortener.application.service.dto.ActualUrlResponse;
import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.application.service.exception.UrlException;
import com.urlshortener.application.service.mapper.ShortenerMapper;
import com.urlshortener.application.service.ports.input.UrlShortenerApplicationService;
import com.urlshortener.application.service.ports.output.CountryIdentifier;
import com.urlshortener.application.service.ports.output.UrlEntityRepository;
import com.urlshortener.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.domain.UrlDomainService;
import com.urlshortener.domain.entity.Url;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlShortenerApplicationServiceImpl implements UrlShortenerApplicationService {
    private final ShortenerMapper shortenerMapper;
    private final UrlMessagePublisher messagePublisher;
    private final UrlEntityRepository urlEntityRepository;
    private final CountryIdentifier countryIdentifier;
    private final UrlDomainService urlDomainService;
    private final IgniteCacheService cacheService;
    @Value("${application.base.uri}")
    private String baseUri;

    @Override
    public UrlShortenedResponse shorten(ShortenUrlCommand shortenUrlCommand) {
        return cacheService.getFromCache(shortenUrlCommand)
            .orElseGet(() -> cacheService.put(shortenUrlCommand,
                                              shortenerMapper.urlToResponse(baseUri, persist(shortenUrlCommand))));
    }

    @Override
    public ActualUrlResponse getActualUrl(String urlId) {
        return new ActualUrlResponse(urlEntityRepository.actualUrl(urlId).getUrl());
    }

    @NotNull
    private Url persist(ShortenUrlCommand shortenUrlCommand) {
        var country = countryIdentifier.identify(shortenUrlCommand.getIpAddress());
        if (log.isInfoEnabled()) {
            log.info("Attempt from {} to shorten url: {}", country, shortenUrlCommand.getUrl());
        }

        var requestDetails = shortenerMapper.shortenCommandToRequestDetails(shortenUrlCommand, country);
        var url = shortenerMapper.shortenCommandToUrl(shortenUrlCommand);
        var shortenedEvent = urlDomainService.shorten(url, requestDetails);

        var savedUrl = urlEntityRepository.persist(url);
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
