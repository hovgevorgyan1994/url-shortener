package com.urlshortener.shortener.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableR2dbcRepositories(basePackages = "com.urlshortener.shortener.service.dataaccess")
@EntityScan(basePackages = "com.urlshortener.shortener.service.dataaccess")
@SpringBootApplication(scanBasePackages = "com.urlshortener")
@EnableWebFlux
public class ShortenerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortenerServiceApplication.class, args);
    }
}
