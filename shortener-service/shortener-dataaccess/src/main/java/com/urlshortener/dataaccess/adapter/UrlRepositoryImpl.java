package com.urlshortener.dataaccess.adapter;

import com.urlshortener.application.service.ports.output.UrlEntityRepository;
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
}
