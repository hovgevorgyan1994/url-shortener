package com.urlshortener.application.service.dto;

import java.util.UUID;

public class UrlShortenedResponse {
    private final String shortenedUrl;

    public UrlShortenedResponse(String baseUri, UUID id) {
        this.shortenedUrl = baseUri.formatted(id.toString());
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
