package com.urlshortener.application.service.ports.output;

public interface CountryIdentifier {
    String identify(String ipAddress);
}
