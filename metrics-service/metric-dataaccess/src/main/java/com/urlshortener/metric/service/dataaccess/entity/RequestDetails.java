package com.urlshortener.metric.service.dataaccess.entity;

import java.time.LocalDateTime;
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
    private String urlId;
    private String url;
    private LocalDateTime expiresAt;
    private String ipAddress;
    private String country;
    private LocalDateTime zonedDatetime;
}
