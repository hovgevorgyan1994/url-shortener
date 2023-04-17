package com.urlshortener.shortener.service.domain;

import com.urlshortener.shortener.service.domain.entity.RequestDetails;
import com.urlshortener.shortener.service.domain.entity.Url;
import com.urlshortener.shortener.service.domain.event.UrlShortenedEvent;

public class UrlDomainServiceImpl implements UrlDomainService {

    @Override
    public UrlShortenedEvent shorten(Url url, RequestDetails details) {
        return new UrlShortenedEvent(url, details.getIpAddress(), details.getCountry(), details.getZonedDateTime());
    }
}
