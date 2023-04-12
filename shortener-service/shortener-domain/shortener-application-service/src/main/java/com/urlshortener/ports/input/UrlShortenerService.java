package com.urlshortener.ports.input;

import com.urlshortener.dto.ShortenUrlCommand;
import com.urlshortener.dto.UrlShortenedResponse;

public interface UrlShortenerService {
    UrlShortenedResponse shorten(ShortenUrlCommand shortenUrlCommand);
}
