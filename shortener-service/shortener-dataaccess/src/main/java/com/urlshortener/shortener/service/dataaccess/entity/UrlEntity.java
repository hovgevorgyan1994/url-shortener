package com.urlshortener.shortener.service.dataaccess.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("url_entity")
public class UrlEntity implements Persistable<UUID> {

    @Id
    private UUID id;
    @Column
    private String url;

    private LocalDateTime expiresAt;

    public UrlEntity(UUID id, String url, LocalDateTime expiresAt) {
        this.id = id;
        this.url = url;
        this.expiresAt = expiresAt;
    }

    @Transient
    private boolean newUrl;

    @Override
    @Transient
    public boolean isNew() {
        return this.newUrl;
    }

    public UrlEntity setAsNew() {
        this.newUrl = true;
        return this;
    }

    public UrlEntity withExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }
}
