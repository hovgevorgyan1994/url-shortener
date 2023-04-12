package com.urlshortener.application.service.ports.output;

import com.urlshortener.domain.entity.Url;

public interface UrlEntityRepository {
    Url persist(Url url);
}
