package com.urlshortener.application.service.cache;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class CacheClientImpl implements CacheClient {

    private final IMap<ShortenUrlCommand, UrlShortenedResponse> responseCache;
    private final IMap<String, Url> urlCache;

    public CacheClientImpl(HazelcastInstance urlCacheHazelcastInstance) {
        this.responseCache = urlCacheHazelcastInstance.getMap("response-cache");
        this.urlCache = urlCacheHazelcastInstance.getMap("url-cache");
    }

    @Override
    public void put(ShortenUrlCommand command, UrlShortenedResponse response) {
        responseCache.put(command, response);
    }

    @Override
    public void put(Url url) {
        urlCache.put(url.getId().getValue().toString(), url);
    }

    @Override
    public UrlShortenedResponse getFromCache(ShortenUrlCommand command) {
        return responseCache.get(command);
    }

    @Override
    public Url getFromCache(String urlId) {
        return urlCache.get(urlId);
    }
}
