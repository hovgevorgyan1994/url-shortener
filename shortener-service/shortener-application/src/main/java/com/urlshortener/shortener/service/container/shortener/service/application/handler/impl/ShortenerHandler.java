package com.urlshortener.shortener.service.container.shortener.service.application.handler.impl;

import static java.net.URI.create;

import com.urlshortener.shortener.service.container.shortener.service.application.handler.ShortenerApi;
import com.urlshortener.shortener.service.application.service.dto.ShortenUrlCommand;
import com.urlshortener.shortener.service.application.service.ports.input.RequestPublishingService;
import com.urlshortener.shortener.service.application.service.ports.input.UrlShortenerApplicationService;
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
    private final RequestPublishingService requestPublishingService;

    @Override
    public Mono<ServerResponse> shortenUrl(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ShortenUrlCommand.class)
            .flatMap(command -> {
                var shortenResponseMono =
                    shortenerApplicationService.shorten(command.withIpAddress(getHostString(serverRequest)));
                return requestPublishingService.publishRequest(command)
                    .then(shortenResponseMono)
                    .flatMap(response -> ServerResponse.ok().bodyValue(response))
                    .onErrorResume(e -> {
                        return shortenResponseMono.flatMap(response -> ServerResponse.ok().bodyValue(response));
                    });
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
