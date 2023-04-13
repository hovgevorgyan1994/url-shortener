package com.urlshortener.application.service.cache;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.domain.entity.Url;

public interface CacheClient {

    void put(ShortenUrlCommand command, UrlShortenedResponse response);

    UrlShortenedResponse responseFromCache(String url);

    void put(Url url);

    Url urlFromCache(String urlId);
}
