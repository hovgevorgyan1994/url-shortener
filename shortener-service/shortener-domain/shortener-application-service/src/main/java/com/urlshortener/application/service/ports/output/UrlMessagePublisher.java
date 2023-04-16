package com.urlshortener.application.service.ports.output;

import com.urlshortener.domain.event.UrlShortenedEvent;
import reactor.core.publisher.Mono;

public interface UrlMessagePublisher {

    Mono<Void> publish(UrlShortenedEvent urlShortenedEvent);
}
