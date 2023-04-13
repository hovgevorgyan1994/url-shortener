package com.urlshortener.application.service.dto;

public record ActualUrlResponse(String actualUrl) {

    public static ActualUrlResponse of(String actualUrl) {
        return new ActualUrlResponse(actualUrl);
    }
}
