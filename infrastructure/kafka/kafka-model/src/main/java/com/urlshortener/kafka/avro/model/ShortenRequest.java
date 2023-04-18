package com.urlshortener.kafka.avro.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortenRequest {

    private String urlId;
    private String url;
    private Instant expiresAt;
    private String ipAddress;
    private String country;
    private Instant zonedDatetime;
}
