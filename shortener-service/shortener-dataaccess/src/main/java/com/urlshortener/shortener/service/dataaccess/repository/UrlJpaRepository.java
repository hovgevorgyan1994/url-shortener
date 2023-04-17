package com.urlshortener.shortener.service.dataaccess.repository;

import java.util.UUID;

import com.urlshortener.shortener.service.dataaccess.entity.UrlEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UrlJpaRepository extends ReactiveCrudRepository<UrlEntity, UUID> {

    Mono<UrlEntity> findByUrl(String url);
}
