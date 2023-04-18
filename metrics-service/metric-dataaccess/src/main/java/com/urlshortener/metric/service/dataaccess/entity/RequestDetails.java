package com.urlshortener.metric.service.dataaccess.entity;

import java.time.Instant;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestDetails {
    @Id
    private UUID id;
    private String url;
    private Instant expiresAt;
    private String ipAddress;
    private String country;
    private Instant zonedDatetime;
}
