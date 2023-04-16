package com.urlshortener;

import com.urlshortener.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.domain.event.UrlShortenedEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UrlMessagePublisherImpl implements UrlMessagePublisher {
    @Override
    public Mono<Void> publish(UrlShortenedEvent urlShortenedEvent) {
        //throw new IllegalStateException("not implemented");
        return null;
    }
}
