package com.urlshortener.shortener.service.application.service.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UrlShortenedResponse implements Serializable {
    private String shortenedUrl;

    public UrlShortenedResponse(String baseUri, UUID id) {
        this.shortenedUrl = baseUri.formatted(id.toString());
    }
}
