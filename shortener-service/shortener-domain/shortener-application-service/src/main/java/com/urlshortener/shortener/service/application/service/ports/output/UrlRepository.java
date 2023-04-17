package com.urlshortener.shortener.service.application.service.ports.output;

import com.urlshortener.shortener.service.domain.entity.Url;
import reactor.core.publisher.Mono;

public interface UrlRepository {
    Mono<Url> persist(Url url);

    Mono<Url> actualUrl(String urlId);
}
