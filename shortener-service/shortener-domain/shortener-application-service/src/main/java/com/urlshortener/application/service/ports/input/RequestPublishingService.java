package com.urlshortener.application.service.ports.input;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import reactor.core.publisher.Mono;

public interface RequestPublishingService {

    Mono<Void> publishRequest(ShortenUrlCommand command);
}
