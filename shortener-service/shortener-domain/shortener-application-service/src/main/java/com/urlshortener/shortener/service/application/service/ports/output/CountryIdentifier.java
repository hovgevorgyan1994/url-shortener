package com.urlshortener.shortener.service.application.service.ports.output;

import reactor.core.publisher.Mono;

public interface CountryIdentifier {
    Mono<String> identify(String ipAddress);
}
