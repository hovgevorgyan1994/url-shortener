package com.urlshortener.dataaccess.adapter;

import static java.util.UUID.fromString;

import com.urlshortener.application.service.ports.output.UrlEntityRepository;
import com.urlshortener.dataaccess.exception.UrlNotFountException;
import com.urlshortener.dataaccess.mapper.UrlEntityMapper;
import com.urlshortener.dataaccess.repository.UrlJpaRepository;
import com.urlshortener.domain.entity.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UrlRepositoryImpl implements UrlEntityRepository {

    private final UrlJpaRepository urlJpaRepository;
    private final UrlEntityMapper urlEntityMapper;

    @Override
    public Url persist(Url url) {
        return urlEntityMapper.toUrl(urlJpaRepository.save(urlEntityMapper.toUrlEntity(url)));
    }

    @Override
    public Url actualUrl(String urlId) {
        var urlEntity = urlJpaRepository.findById(fromString(urlId))
            .orElseThrow(() -> new UrlNotFountException("Url with id %s does not exist!".formatted(urlId)));
        return urlEntityMapper.toUrl(urlEntity);
    }
}
