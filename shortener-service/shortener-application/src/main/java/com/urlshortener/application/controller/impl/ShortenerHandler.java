package com.urlshortener.application.controller.impl;

import static java.time.ZonedDateTime.now;

import com.urlshortener.application.controller.ShortenerApi;
import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.application.service.ports.input.UrlShortenerApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ShortenerHandler implements ShortenerApi {

    private final UrlShortenerApplicationService shortenerApplicationService;

    @Override
    public Mono<ServerResponse> shortenUrl(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ShortenUrlCommand.class)
            .flatMap(shortenUrlCommand -> {
                var response = shortenerApplicationService
                    .shorten(shortenUrlCommand.withRequestDetails(getHostString(serverRequest), now()));
                return ServerResponse.ok().body(Mono.just(response), UrlShortenedResponse.class);
            });
    }

    @Override
    public Mono<ServerResponse> getActualUrl(ServerRequest serverRequest) {
        return ServerResponse.ok().body(Mono.just("tvac url-y"), String.class);
    }

    private static String getHostString(ServerRequest serverRequest) {
        return serverRequest.exchange().getRequest().getRemoteAddress().getHostString();
    }
}
