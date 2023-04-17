package com.urlshortener.shortener.service.application.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties(prefix = "shortener-service")
public class ShortenerServiceConfigData {
    private String shortenRequestTopicName;
}
