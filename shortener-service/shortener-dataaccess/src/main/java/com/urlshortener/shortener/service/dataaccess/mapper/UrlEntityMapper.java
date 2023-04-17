package com.urlshortener.shortener.service.dataaccess.mapper;

import com.urlshortener.common.domain.valueobject.UrlId;
import com.urlshortener.shortener.service.dataaccess.entity.UrlEntity;
import com.urlshortener.shortener.service.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class UrlEntityMapper {

    public UrlEntity toUrlEntity(Url url) {
        return new UrlEntity(url.getId().getValue(), url.getUrl(), url.getExpiresAt()).setAsNew();
    }

    public Url toUrl(UrlEntity urlEntity) {
        Url url = new Url(urlEntity.getUrl());
        url.setId(new UrlId(urlEntity.getId()));
        return url.withExpiration(url.getExpiresAt());
    }
}
