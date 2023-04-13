package com.urlshortener.country.identifier;

import java.net.http.HttpClient;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
@ConfigurationProperties(prefix = "countryidentifier.config")
public class CountryIdentifierConfig {

    private String ipStackApiKey;
    private String ipStackUri;

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }

    public String getIpStackUri(String ipAddress) {
        return ipStackUri.formatted(ipAddress, ipStackApiKey);
    }
}
