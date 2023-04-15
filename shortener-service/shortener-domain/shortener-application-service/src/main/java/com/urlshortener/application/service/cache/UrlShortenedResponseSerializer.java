package com.urlshortener.application.service.cache;

import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.common.cache.hazelcast.config.HazelCastSerializer;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenedResponseSerializer extends HazelCastSerializer<UrlShortenedResponse> {
    public UrlShortenedResponseSerializer() {
        super(UrlShortenedResponse.class, 2);
    }
}
