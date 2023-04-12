package com.urlshortener.application.service.dto;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public final class ShortenUrlCommand {
    private String url;
    private Long expiration;
    private ChronoUnit chronoUnit;
    private String ipAddress;
    private ZonedDateTime zonedDateTime;

    public ShortenUrlCommand withRequestDetails(String ipAddress, ZonedDateTime zonedDateTime) {
        this.ipAddress = ipAddress;
        this.zonedDateTime = zonedDateTime;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public ChronoUnit getChronoUnit() {
        return chronoUnit;
    }

    public void setChronoUnit(ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }
}
