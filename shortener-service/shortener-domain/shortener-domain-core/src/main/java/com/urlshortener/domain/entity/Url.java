package com.urlshortener.domain.entity;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.urlshortener.entity.BaseEntity;
import com.urlshortener.valueobject.UrlId;

public class Url extends BaseEntity<UrlId> {
    private final String url;
    private LocalDateTime expiresAt;

    public Url(String givenUrl) {
        this.url = givenUrl;
    }

    public Url withExpiration(long time, ChronoUnit chronoUnit) {
        this.expiresAt = switch (chronoUnit) {
            case SECONDS -> now().plusSeconds(time);
            case MINUTES -> now().plusMinutes(time);
            case HOURS -> now().plusHours(time);
            case DAYS -> now().plusDays(time);
            case WEEKS -> now().plusWeeks(time);
            case MONTHS -> now().plusMonths(time);
            case YEARS -> now().plusYears(time);
            default -> null;
        };
        return this;
    }

    public Url withExpiration(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
