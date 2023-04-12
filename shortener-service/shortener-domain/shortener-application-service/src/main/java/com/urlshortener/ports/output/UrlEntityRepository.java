package com.urlshortener.ports.output;

import com.urlshortener.entity.UrlEntity;

public interface UrlEntityRepository {

    UrlEntity persist(UrlEntity urlEntity);
}
