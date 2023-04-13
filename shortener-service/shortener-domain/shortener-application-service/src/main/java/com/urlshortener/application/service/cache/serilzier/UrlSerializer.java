package com.urlshortener.application.service.cache.serilzier;

import com.urlshortener.domain.entity.Url;
import org.springframework.stereotype.Component;

@Component
public class UrlSerializer extends HazelCastSerializer<Url> {
    public UrlSerializer() {
        super(Url.class);
    }

    @Override
    public int getTypeId() {
        return 3;
    }
}
