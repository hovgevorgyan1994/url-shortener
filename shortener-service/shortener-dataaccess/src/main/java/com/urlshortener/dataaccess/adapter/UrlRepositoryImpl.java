package com.urlshortener.dataaccess.adapter;

import static java.util.UUID.fromString;

import com.urlshortener.application.service.ports.output.UrlRepository;
import com.urlshortener.dataaccess.entity.UrlEntity;
import com.urlshortener.dataaccess.exception.UrlNotFountException;
import com.urlshortener.dataaccess.mapper.UrlEntityMapper;
import com.urlshortener.dataaccess.repository.UrlJpaRepository;
import com.urlshortener.domain.entity.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UrlRepositoryImpl implements UrlRepository {

    private final UrlJpaRepository urlJpaRepository;
    private final UrlEntityMapper urlEntityMapper;

    @Override
    @Transactional
    public Url persist(Url url) {
        var optionalUrl = urlJpaRepository.findByUrl(url.getUrl());
        UrlEntity urlEntity;
        if (optionalUrl.isEmpty()) {
            urlEntity = urlJpaRepository.save(urlEntityMapper.toUrlEntity(url));
        } else {
            urlEntity = optionalUrl.get().withExpiresAt(url.getExpiresAt());
        }
        return urlEntityMapper.toUrl(urlEntity);
    }

    @Override
    public Url actualUrl(String urlId) {
        var urlEntity = urlJpaRepository.findById(fromString(urlId))
            .orElseThrow(() -> new UrlNotFountException("Url with id %s does not exist!".formatted(urlId)));
        return urlEntityMapper.toUrl(urlEntity);
    }
}
