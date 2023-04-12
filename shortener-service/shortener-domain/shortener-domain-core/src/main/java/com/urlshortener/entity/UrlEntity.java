package com.urlshortener.entity;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class UrlEntity extends BaseEntity<UUID> {

    private final String givenUrl;
    private final String shortenedUrl;
    private LocalDateTime expiresAt;

    public UrlEntity(String givenUrl, String shortenedUrl) {
        this.givenUrl = givenUrl;
        this.shortenedUrl = shortenedUrl;
    }

    public void setExpireIn(long time, ChronoUnit chronoUnit) {
        expiresAt = switch (chronoUnit) {
            case SECONDS -> now().plusSeconds(time);
            case MINUTES -> now().plusMinutes(time);
            case HOURS -> now().plusHours(time);
            case DAYS -> now().plusDays(time);
            case WEEKS -> now().plusWeeks(time);
            case MONTHS -> now().plusMonths(time);
            case YEARS -> now().plusYears(time);
            default -> null;
        };
    }

    public String getGivenUrl() {
        return givenUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
