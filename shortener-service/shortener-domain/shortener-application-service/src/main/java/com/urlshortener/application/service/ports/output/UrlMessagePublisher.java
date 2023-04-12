package com.urlshortener.application.service.ports.output;

import com.urlshortener.domain.event.UrlShortenedEvent;

public interface UrlMessagePublisher {

    void publish(UrlShortenedEvent urlShortenedEvent);
}
