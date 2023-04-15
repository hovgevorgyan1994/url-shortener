package com.urlshortener.domain.entity;

import java.time.Instant;

import com.urlshortener.common.domain.entity.BaseEntity;
import com.urlshortener.common.domain.valueobject.RequestId;

public class RequestDetails extends BaseEntity<RequestId> {
    private final String ipAddress;
    private final Instant zonedDateTime;
    private String country;

    public RequestDetails(String ipAddress, Instant zonedDateTime) {
        this.ipAddress = ipAddress;
        this.zonedDateTime = zonedDateTime;
    }

    public RequestDetails withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Instant getZonedDateTime() {
        return zonedDateTime;
    }

    public String getCountry() {
        return country;
    }
}
