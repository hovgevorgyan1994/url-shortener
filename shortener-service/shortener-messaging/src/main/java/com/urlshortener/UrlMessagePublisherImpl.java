package com.urlshortener;

import com.urlshortener.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.domain.event.UrlShortenedEvent;
import org.springframework.stereotype.Component;

@Component
public class UrlMessagePublisherImpl implements UrlMessagePublisher {
    @Override
    public void publish(UrlShortenedEvent urlShortenedEvent) {
        throw new IllegalStateException("not implemented");
    }
}
