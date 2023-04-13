package com.urlshortener.domain.event;

import java.time.Instant;

import com.urlshortener.domain.entity.Url;
import com.urlshortener.event.DomainEvent;

public record UrlShortenedEvent(Url url, String ipAddress, String country,
                                Instant zonedDateTime) implements DomainEvent {

}
