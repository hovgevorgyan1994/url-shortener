package com.urlshortener.dataaccess.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UrlEntity {
    @Id
    private UUID id;
    @Column(columnDefinition = "TEXT")
    private String url;
    @With
    private LocalDateTime expiresAt;
}
