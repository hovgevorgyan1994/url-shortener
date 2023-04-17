package com.urlshortener.shortener.service.container.shortener.service.application.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.urlshortener.shortener.service.container.shortener.service.application.handler.ShortenerApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ShortenApiRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(ShortenerApi shortenerApi) {
        return route(POST("/shorten"), shortenerApi::shortenUrl)
            .andRoute(GET("url/{id}"), shortenerApi::getActualUrl);
    }
}
