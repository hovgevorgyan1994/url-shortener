package com.urlshortener.shortener.service.container.shortener.service.country.identifier;

import java.net.URI;

import com.urlshortener.shortener.service.application.service.ports.output.CountryIdentifier;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CountryIdentifierImpl implements CountryIdentifier {
    private static final String COUNTRY_NAME = "country_name";
    private final WebClient webClient;
    private final CountryIdentifierConfig config;

    @Override
    public Mono<String> identify(String ipAddress) {
        return webClient.get()
            .uri(URI.create(config.getIpStackUri(ipAddress)))
            .exchangeToMono(response -> response.bodyToMono(String.class)
                .map(s -> {
                    try {
                        return new JSONObject(s).getString(COUNTRY_NAME);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }));
    }
}
