package com.urlshortener.cache.config.serializer;

import com.urlshortener.application.service.dto.UrlShortenedResponse;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenedResponseSerializer extends HazelCastSerializer<UrlShortenedResponse> {
    public UrlShortenedResponseSerializer() {
        super(UrlShortenedResponse.class, 1);
    }
}
