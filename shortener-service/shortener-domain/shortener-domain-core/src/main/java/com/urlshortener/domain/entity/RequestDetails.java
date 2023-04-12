package com.urlshortener.domain.entity;

import java.time.ZonedDateTime;

import com.urlshortener.entity.BaseEntity;
import com.urlshortener.valueobject.RequestId;

public class RequestDetails extends BaseEntity<RequestId> {
    private final String ipAddress;
    private final ZonedDateTime zonedDateTime;
    private String country;

    public RequestDetails(String ipAddress, ZonedDateTime zonedDateTime) {
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

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public String getCountry() {
        return country;
    }
}
