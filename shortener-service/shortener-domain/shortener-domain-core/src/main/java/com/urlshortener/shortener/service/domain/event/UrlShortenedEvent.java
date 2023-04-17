package com.urlshortener.shortener.service.domain.event;

import java.time.Instant;

import com.urlshortener.shortener.service.domain.entity.Url;
import com.urlshortener.common.domain.event.DomainEvent;

public record UrlShortenedEvent(Url url, String ipAddress, String country,
                                Instant zonedDateTime) implements DomainEvent {

}
