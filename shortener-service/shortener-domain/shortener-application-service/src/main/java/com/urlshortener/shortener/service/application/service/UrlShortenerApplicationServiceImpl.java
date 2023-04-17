package com.urlshortener.shortener.service.application.service;

import static java.util.concurrent.TimeUnit.HOURS;

import com.urlshortener.shortener.service.application.service.dto.ActualUrlResponse;
import com.urlshortener.shortener.service.application.service.dto.ShortenUrlCommand;
import com.urlshortener.shortener.service.application.service.dto.UrlShortenedResponse;
import com.urlshortener.shortener.service.application.service.mapper.ShortenerMapper;
import com.urlshortener.shortener.service.application.service.ports.input.UrlShortenerApplicationService;
import com.urlshortener.shortener.service.application.service.ports.output.UrlRepository;
import com.urlshortener.common.cache.CacheClient;
import com.urlshortener.shortener.service.domain.entity.Url;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlShortenerApplicationServiceImpl implements UrlShortenerApplicationService {
    private final UrlRepository urlRepository;
    private final ShortenerMapper shortenerMapper;
    private final CacheClient<String, Url> urlCacheClient;
    private final CacheClient<String, UrlShortenedResponse> responseCacheClient;
    @Value("${application.base.uri}")
    private String baseUri;

    @Override
    public Mono<UrlShortenedResponse> shorten(ShortenUrlCommand shortenUrlCommand) {
        return responseCacheClient.get(shortenUrlCommand.getUrl())
            .switchIfEmpty(saveAndReturn(shortenUrlCommand));
    }

    @Override
    public Mono<ActualUrlResponse> getActualUrl(String urlId) {
        return urlCacheClient.get(urlId)
            .map(url -> ActualUrlResponse.of(url.getUrl()))
            .switchIfEmpty(urlRepository.actualUrl(urlId)
                               .flatMap(url -> urlCacheClient.cache(url.getUrl(), url, 10, HOURS)
                                   .then(Mono.just(ActualUrlResponse.of(url.getUrl())))));
    }

    private Mono<UrlShortenedResponse> saveAndReturn(ShortenUrlCommand shortenUrlCommand) {
        return urlRepository.persist(shortenerMapper.shortenCommandToUrl(shortenUrlCommand))
            .flatMap(url -> urlCacheClient.cache(url.getId().getValue().toString(), url)
                .then(responseCacheClient.cache(shortenUrlCommand.getUrl(),
                                                shortenerMapper.urlToResponse(baseUri, url),
                                                300))
                .onErrorResume(e -> {
                    log.error("Cache operation failed: {}", e.getMessage());
                    return Mono.just(new UrlShortenedResponse(baseUri, url.getId().getValue()));
                }));
    }
}
