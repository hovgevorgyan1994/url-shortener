package com.urlshortener.dataaccess.mapper;

import com.urlshortener.dataaccess.entity.UrlEntity;
import com.urlshortener.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class UrlEntityMapper {

    public UrlEntity toUrlEntity(Url url) {
        return new UrlEntity(url.getId().getValue(), url.getUrl(), url.getExpiresAt());
    }

    public Url toUrl(UrlEntity urlEntity) {
        Url url = new Url(urlEntity.getUrl());
        return url.withExpiration(url.getExpiresAt());
    }
}
