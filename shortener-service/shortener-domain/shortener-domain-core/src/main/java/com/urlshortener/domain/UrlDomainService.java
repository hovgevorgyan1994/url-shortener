package com.urlshortener.domain;

import com.urlshortener.domain.entity.RequestDetails;
import com.urlshortener.domain.entity.Url;
import com.urlshortener.domain.event.UrlShortenedEvent;

public interface UrlDomainService {
    UrlShortenedEvent shorten(Url url, RequestDetails requestDetails);
}
