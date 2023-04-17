package com.urlshortener.shortener.service.application.service.ports.output;

import com.urlshortener.shortener.service.domain.event.UrlShortenedEvent;
import reactor.core.publisher.Mono;

public interface UrlMessagePublisher {

    Mono<Void> publish(UrlShortenedEvent urlShortenedEvent);
}
