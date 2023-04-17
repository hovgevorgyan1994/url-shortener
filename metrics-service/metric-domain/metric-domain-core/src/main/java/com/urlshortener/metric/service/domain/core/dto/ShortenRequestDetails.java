package com.urlshortener.metric.service.domain.core.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ShortenRequestDetails {
    private String id;
    private String url;
    private LocalDateTime expiresAt;
    private String ipAddress;
    private String country;
    private Instant zonedDateTime;
}
