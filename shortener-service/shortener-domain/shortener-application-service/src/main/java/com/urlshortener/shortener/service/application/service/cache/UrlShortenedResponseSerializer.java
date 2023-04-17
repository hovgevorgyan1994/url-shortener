package com.urlshortener.shortener.service.application.service.cache;

import com.urlshortener.shortener.service.application.service.dto.UrlShortenedResponse;
import com.urlshortener.common.cache.hazelcast.config.HazelCastSerializer;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenedResponseSerializer extends HazelCastSerializer<UrlShortenedResponse> {
    public UrlShortenedResponseSerializer() {
        super(UrlShortenedResponse.class, 2);
    }
}
