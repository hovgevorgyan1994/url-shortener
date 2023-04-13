package com.urlshortener.application.service.ports.input;

import com.urlshortener.application.service.dto.ActualUrlResponse;
import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import reactor.core.publisher.Mono;

public interface UrlShortenerApplicationService {
    Mono<UrlShortenedResponse> shorten(ShortenUrlCommand shortenUrlCommand);

    Mono<ActualUrlResponse> getActualUrl(String urlId);
}
