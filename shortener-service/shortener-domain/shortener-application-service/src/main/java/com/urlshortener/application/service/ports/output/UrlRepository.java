package com.urlshortener.application.service.ports.output;

import com.urlshortener.domain.entity.Url;
import reactor.core.publisher.Mono;

public interface UrlRepository {
    Mono<Url> persist(Url url);

    Mono<Url> actualUrl(String urlId);
}
