package com.urlshortener.application.service.mapper;

import static java.util.UUID.randomUUID;

import java.util.Optional;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.domain.entity.RequestDetails;
import com.urlshortener.domain.entity.Url;
import com.urlshortener.valueobject.UrlId;
import org.springframework.stereotype.Component;

@Component
public class ShortenerMapper {

    public Url shortenCommandToUrl(ShortenUrlCommand shortenUrlCommand) {
        var url = new Url(shortenUrlCommand.getUrl());
        url.setId(new UrlId(randomUUID()));
        return Optional.ofNullable(shortenUrlCommand.getExpiration())
            .map(expiration -> url.withExpiration(expiration, shortenUrlCommand.getTimeUnit()))
            .orElse(url);
    }

    public RequestDetails shortenCommandToRequestDetails(ShortenUrlCommand command, String country) {
        return new RequestDetails(command.getIpAddress(), command.getZonedDateTime()).withCountry(country);
    }

    public UrlShortenedResponse urlToResponse(String baseUri,Url urlEntity) {
        return new UrlShortenedResponse(baseUri,urlEntity.getId().getValue());
    }
}
