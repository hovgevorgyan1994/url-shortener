package com.urlshortener.application.service.cache.serilzier;

import com.urlshortener.application.service.dto.UrlShortenedResponse;
import org.springframework.stereotype.Component;

@Component
public class UrlShortenedResponseSerializer extends HazelCastSerializer<UrlShortenedResponse> {
    public UrlShortenedResponseSerializer() {
        super(UrlShortenedResponse.class);
    }

    @Override
    public int getTypeId() {
        return 2;
    }
}
