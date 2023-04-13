package com.urlshortener.application.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class ShortenUrlCommand implements Serializable {
    private String url;
    private Long expiration;
    private ChronoUnit chronoUnit;
    private String ipAddress;
    private Instant zonedDateTime;

    public ShortenUrlCommand withRequestDetails(String ipAddress, Instant zonedDateTime) {
        this.ipAddress = ipAddress;
        this.zonedDateTime = zonedDateTime;
        return this;
    }
}
