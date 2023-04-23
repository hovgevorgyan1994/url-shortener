package com.urlshortener.shortener.service.container.shortener.service.country.identifier;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Setter
@Configuration
@ConfigurationProperties(prefix = "countryidentifier")
public class CountryIdentifierConfig {

    private String ipStackApiKey;
    private String ipStackUri;


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
            .build();
    }

    public String getIpStackUri(String ipAddress) {
        return ipStackUri.formatted(ipAddress, ipStackApiKey);
    }
}
