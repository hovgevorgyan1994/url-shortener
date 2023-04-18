package com.urlshortener.shortener.service.messaging.mapper;

import com.urlshortener.kafka.avro.model.ShortenRequest;
import com.urlshortener.shortener.service.domain.event.UrlShortenedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShortenRequestMapper {

    public ShortenRequest eventToProtoModel(UrlShortenedEvent event) {
        return ShortenRequest.builder()
            .urlId(event.url().getId().getValue().toString())
            .url(event.url().getUrl())
            .expiresAt(event.zonedDateTime())
            .ipAddress(event.ipAddress())
            .country(event.country())
            .zonedDatetime(event.zonedDateTime())
            .build();
    }
}
