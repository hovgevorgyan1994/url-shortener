package com.urlshortener.application.service.ports.input;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;

public interface UrlShortenerApplicationService {
    UrlShortenedResponse shorten(ShortenUrlCommand shortenUrlCommand);
}
