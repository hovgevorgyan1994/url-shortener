package com.urlshortener.shortener.service.application.service.cache;

import com.urlshortener.common.cache.hazelcast.config.HazelCastSerializer;
import com.urlshortener.shortener.service.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class UrlSerializer extends HazelCastSerializer<Url> {
    public UrlSerializer() {
        super(Url.class, 1);
    }
}
