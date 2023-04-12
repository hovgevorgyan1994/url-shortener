package com.urlshortener.domain.event;

import java.time.ZonedDateTime;

import com.urlshortener.domain.entity.Url;
import com.urlshortener.event.DomainEvent;

public record UrlShortenedEvent(Url url, String ipAddress, String country,
                                ZonedDateTime zonedDateTime) implements DomainEvent {

}
