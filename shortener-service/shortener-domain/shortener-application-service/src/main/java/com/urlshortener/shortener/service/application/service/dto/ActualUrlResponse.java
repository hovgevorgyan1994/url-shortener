package com.urlshortener.shortener.service.application.service.dto;

public record ActualUrlResponse(String actualUrl) {

    public static ActualUrlResponse of(String actualUrl) {
        return new ActualUrlResponse(actualUrl);
    }
}
