package com.urlshortener.application.service.cache.serilzier;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import org.springframework.stereotype.Component;

@Component
public class ShortenUrlCommandSerializer extends HazelCastSerializer<ShortenUrlCommand> {
    public ShortenUrlCommandSerializer() {
        super(ShortenUrlCommand.class);
    }

    @Override
    public int getTypeId() {
        return 1;
    }
}
