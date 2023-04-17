package com.urlshortener.shortener.service.application.service.ports.input;

import com.urlshortener.shortener.service.application.service.dto.ActualUrlResponse;
import com.urlshortener.shortener.service.application.service.dto.ShortenUrlCommand;
import com.urlshortener.shortener.service.application.service.dto.UrlShortenedResponse;
import reactor.core.publisher.Mono;

public interface UrlShortenerApplicationService {
    Mono<UrlShortenedResponse> shorten(ShortenUrlCommand shortenUrlCommand);

    Mono<ActualUrlResponse> getActualUrl(String urlId);
}
