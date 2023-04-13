package com.urlshortener.application.service.ports.output;

import com.urlshortener.domain.entity.Url;

public interface UrlRepository {
    Url persist(Url url);

    Url actualUrl(String urlId);
}
