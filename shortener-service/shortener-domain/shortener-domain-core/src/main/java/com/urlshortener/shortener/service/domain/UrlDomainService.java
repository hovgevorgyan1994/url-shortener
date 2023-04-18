package com.urlshortener.shortener.service.domain;

import com.urlshortener.shortener.service.domain.entity.RequestDetails;
import com.urlshortener.shortener.service.domain.entity.Url;
import com.urlshortener.shortener.service.domain.event.UrlShortenedEvent;

public interface UrlDomainService {
    UrlShortenedEvent shorten(Url url, RequestDetails requestDetails);

}
