package com.urlshortener.application.service.cache;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.domain.entity.Url;

public interface CacheClient {

    void put(ShortenUrlCommand command, UrlShortenedResponse response);

    UrlShortenedResponse getFromCache(ShortenUrlCommand command);

    void put(Url url);

    Url getFromCache(String urlId);
}
