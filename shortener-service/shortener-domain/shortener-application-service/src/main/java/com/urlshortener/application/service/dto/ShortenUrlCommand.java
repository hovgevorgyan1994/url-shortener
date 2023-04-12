package com.urlshortener.application.service.dto;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public record ShortenUrlCommand(String url, Long expiration, ChronoUnit chronoUnit,
                                String ipAddress, ZonedDateTime zonedDateTime) {
}
