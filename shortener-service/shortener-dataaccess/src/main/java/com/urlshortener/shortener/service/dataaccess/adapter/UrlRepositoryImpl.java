package com.urlshortener.shortener.service.dataaccess.adapter;

import static java.util.UUID.fromString;

import com.urlshortener.shortener.service.application.service.ports.output.UrlRepository;
import com.urlshortener.shortener.service.dataaccess.mapper.UrlEntityMapper;
import com.urlshortener.shortener.service.dataaccess.repository.UrlJpaRepository;
import com.urlshortener.shortener.service.domain.entity.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UrlRepositoryImpl implements UrlRepository {

    private final UrlJpaRepository urlJpaRepository;
    private final UrlEntityMapper urlEntityMapper;

    @Override
    @Transactional
    public Mono<Url> persist(Url url) {
        return urlJpaRepository.findByUrl(url.getUrl())
            .map(urlEntity -> urlEntity.withExpiresAt(url.getExpiresAt()))
            .switchIfEmpty(urlJpaRepository.save(urlEntityMapper.toUrlEntity(url))).log("asdasd`")
            .map(urlEntityMapper::toUrl);
    }

    @Override
    public Mono<Url> actualUrl(String urlId) {
        return urlJpaRepository.findById(fromString(urlId))
            .map(urlEntityMapper::toUrl);
    }
}
