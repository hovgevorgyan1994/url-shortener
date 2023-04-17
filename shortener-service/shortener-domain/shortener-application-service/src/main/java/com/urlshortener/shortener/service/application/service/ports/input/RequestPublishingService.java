package com.urlshortener.shortener.service.application.service.ports.input;

import com.urlshortener.shortener.service.application.service.dto.ShortenUrlCommand;
import reactor.core.publisher.Mono;

public interface RequestPublishingService {

    Mono<Void> publishRequest(ShortenUrlCommand command);
}
