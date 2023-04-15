package com.urlshortener.cache.config.serializer;

import com.urlshortener.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class UrlSerializer extends HazelCastSerializer<Url> {
    public UrlSerializer() {
        super(Url.class, 1);
    }
}
