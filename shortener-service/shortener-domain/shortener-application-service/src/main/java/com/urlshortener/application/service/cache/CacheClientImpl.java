package com.urlshortener.application.service.cache;

import static java.util.concurrent.TimeUnit.MINUTES;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class CacheClientImpl implements CacheClient {

    private final IMap<String, UrlShortenedResponse> responseCache;
    private final IMap<String, Url> urlCache;
    private final CacheConfig config;

    public CacheClientImpl(HazelcastInstance urlCacheHazelcastInstance, CacheConfig cacheConfig) {
        this.responseCache = urlCacheHazelcastInstance.getMap(cacheConfig.getResponseCache());
        this.urlCache = urlCacheHazelcastInstance.getMap(cacheConfig.getUrlCache());
        this.config = cacheConfig;
    }

    @Override
    public void put(ShortenUrlCommand command, UrlShortenedResponse response) {
        responseCache.put(command.getUrl(), response, config.getExpiration(), MINUTES);
    }

    @Override
    public void put(Url url) {
        urlCache.put(url.getId().getValue().toString(), url, config.getExpiration(), MINUTES);
    }

    @Override
    public UrlShortenedResponse responseFromCache(String url) {
        return responseCache.get(url);
    }

    @Override
    public Url urlFromCache(String urlId) {
        return urlCache.get(urlId);
    }
}
