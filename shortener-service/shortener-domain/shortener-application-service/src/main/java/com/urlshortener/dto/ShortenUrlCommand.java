package com.urlshortener.dto;

import java.time.temporal.ChronoUnit;

public record ShortenUrlCommand(String url, long expiration, ChronoUnit chronoUnit) {
}
