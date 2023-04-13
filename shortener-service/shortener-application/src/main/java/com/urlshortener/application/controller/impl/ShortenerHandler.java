package com.urlshortener.application.controller.impl;

import static java.net.URI.create;

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
@SuppressWarnings("all")
public class ShortenerHandler implements ShortenerApi {

    private final UrlShortenerApplicationService shortenerApplicationService;

    @Override
    public Mono<ServerResponse> shortenUrl(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ShortenUrlCommand.class)
            .flatMap(command -> {
                var response = shortenerApplicationService.shorten(command.withIpAddress(getHostString(serverRequest)));
                return ServerResponse.ok().body(response, UrlShortenedResponse.class);
            });
    }

    @Override
    public Mono<ServerResponse> getActualUrl(ServerRequest serverRequest) {
        return shortenerApplicationService.getActualUrl(serverRequest.pathVariable("id"))
            .flatMap(res -> ServerResponse.temporaryRedirect(create(res.actualUrl())).build());
    }

    private static String getHostString(ServerRequest serverRequest) {
        return serverRequest.exchange().getRequest().getRemoteAddress().getHostString();
    }
}
