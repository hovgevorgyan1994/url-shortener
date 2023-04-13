package com.urlshortener.application.service.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlShortenedResponse implements Serializable {
    private String shortenedUrl;

    public UrlShortenedResponse() {
    }

    public UrlShortenedResponse(String baseUri, UUID id) {
        this.shortenedUrl = baseUri.formatted(id.toString());
    }
}
