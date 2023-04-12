package com.urlshortener.application.service.dto;

import java.util.UUID;

public class UrlShortenedResponse {
    private static final String BASE_URI = "http://localhost:8888?id=%s";
    private final String shortenedUrl;

    public UrlShortenedResponse(UUID id) {
        this.shortenedUrl = BASE_URI.formatted(id);
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }
}
