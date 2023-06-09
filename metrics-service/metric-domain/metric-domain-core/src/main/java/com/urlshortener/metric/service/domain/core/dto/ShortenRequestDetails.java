package com.urlshortener.metric.service.domain.core.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortenRequestDetails {
    private String url;
    private Instant expiresAt;
    private String ipAddress;
    private String country;
    private Instant zonedDatetime;
}
