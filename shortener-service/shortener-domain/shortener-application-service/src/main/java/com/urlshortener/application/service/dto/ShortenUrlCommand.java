package com.urlshortener.application.service.dto;

import java.io.Serializable;
import java.time.Instant;

import com.urlshortener.common.domain.dto.TimeUnit;
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
    private TimeUnit timeUnit;
    private String ipAddress;
    private Instant zonedDateTime;

    public ShortenUrlCommand withIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }
}
