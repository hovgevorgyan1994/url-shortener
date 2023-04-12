package com.urlshortener.domain;

import com.urlshortener.domain.entity.RequestDetails;
import com.urlshortener.domain.entity.Url;
import com.urlshortener.domain.event.UrlShortenedEvent;

public class UrlDomainServiceImpl implements UrlDomainService {

    @Override
    public UrlShortenedEvent shorten(Url url, RequestDetails details) {
        return new UrlShortenedEvent(url, details.getIpAddress(), details.getCountry(), details.getZonedDateTime());
    }
}
