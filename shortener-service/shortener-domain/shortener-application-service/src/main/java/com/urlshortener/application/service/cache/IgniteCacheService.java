package com.urlshortener.application.service.cache;

import static javax.cache.expiry.CreatedExpiryPolicy.factoryOf;
import static javax.cache.expiry.Duration.ONE_HOUR;

import java.util.Optional;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.stereotype.Service;

@Service
public class IgniteCacheService {
    private final IgniteCache<ShortenUrlCommand, UrlShortenedResponse> cache;

    public IgniteCacheService(Ignite ignite) {
        this.cache = ignite.<ShortenUrlCommand, UrlShortenedResponse>getOrCreateCache("url-cache")
            .withExpiryPolicy(factoryOf(ONE_HOUR).create());
    }

    public void put(ShortenUrlCommand command, UrlShortenedResponse response) {
        cache.put(command, response);
    }

    public Optional<UrlShortenedResponse> getFromCache(ShortenUrlCommand command) {
        return Optional.ofNullable(cache.get(command));
    }
}
