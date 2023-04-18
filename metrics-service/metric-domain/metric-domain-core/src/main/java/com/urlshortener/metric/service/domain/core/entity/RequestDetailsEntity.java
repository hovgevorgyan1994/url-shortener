package com.urlshortener.metric.service.domain.core.entity;

import static java.util.UUID.randomUUID;

import java.time.Instant;

import com.urlshortener.common.domain.entity.BaseEntity;
import com.urlshortener.metric.service.domain.core.valueobject.DetailsEntityId;

public class RequestDetailsEntity extends BaseEntity<DetailsEntityId> {
    private final String url;
    private final Instant expiresAt;
    private final String ipAddress;
    private final String country;
    private final Instant zonedDatetime;

    public RequestDetailsEntity(String url, Instant expiresAt,
                                String ipAddress, String country, Instant zonedDatetime) {
        setId(new DetailsEntityId(randomUUID()));
        this.url = url;
        this.expiresAt = expiresAt;
        this.ipAddress = ipAddress;
        this.country = country;
        this.zonedDatetime = zonedDatetime;
    }

    @Override
    public void setId(DetailsEntityId requestId) {
        super.setId(requestId);
    }
    public String getUrl() {
        return url;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCountry() {
        return country;
    }

    public Instant getZonedDatetime() {
        return zonedDatetime;
    }
}
