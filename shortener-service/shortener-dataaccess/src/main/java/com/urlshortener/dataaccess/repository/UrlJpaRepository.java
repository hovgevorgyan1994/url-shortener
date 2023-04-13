package com.urlshortener.dataaccess.repository;

import java.util.Optional;
import java.util.UUID;

import com.urlshortener.dataaccess.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlJpaRepository extends JpaRepository<UrlEntity, UUID> {

    Optional<UrlEntity> findByUrl(String url);
}
