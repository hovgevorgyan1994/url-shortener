package com.urlshortener.shortener.service.messaging.mapper;

import java.time.Instant;

import com.urlshortener.kafka.avro.model.ShortenRequestAvroModel;
import com.urlshortener.shortener.service.domain.event.UrlShortenedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShortenRequestMapper {

    public ShortenRequestAvroModel eventToAvroModel(UrlShortenedEvent event) {
        return ShortenRequestAvroModel.newBuilder()
            .setId(event.url().getId().getValue().toString())
            .setUrl(event.url().getUrl())
            .setExpiresAat(Instant.now())
            .setIpAddress(event.ipAddress())
            .setCountry(event.country())
            .setZonedDateTime(Instant.now())
            .build();
    }
}
