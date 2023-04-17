package com.urlshortener.metric.service.domain.core.entity;

import static java.util.UUID.randomUUID;

import java.time.LocalDateTime;

import com.urlshortener.common.domain.entity.BaseEntity;
import com.urlshortener.metric.service.domain.core.valueobject.DetailsEntityId;

public class RequestDetailsEntity extends BaseEntity<DetailsEntityId> {

    private final String urlId;
    private final String url;
    private final LocalDateTime expiresAt;
    private final String ipAddress;
    private final String country;
    private final LocalDateTime zonedDatetime;

    public RequestDetailsEntity(String urlId, String url, LocalDateTime expiresAt,
                                String ipAddress, String country, LocalDateTime zonedDatetime) {
        setId(new DetailsEntityId(randomUUID()));
        this.urlId = urlId;
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

    public String getUrlId() {
        return urlId;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getZonedDatetime() {
        return zonedDatetime;
    }
}
