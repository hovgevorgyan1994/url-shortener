package com.urlshortener.application.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ShortenerApi {
    Mono<ServerResponse> shortenUrl(ServerRequest serverRequest);
    Mono<ServerResponse> getActualUrl(ServerRequest serverRequest);
}
