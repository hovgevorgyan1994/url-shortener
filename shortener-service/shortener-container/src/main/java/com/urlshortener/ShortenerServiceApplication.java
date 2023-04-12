package com.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableJpaRepositories(basePackages = "com.urlshortener.dataaccess")
@EntityScan(basePackages = "com.urlshortener.dataaccess")
@SpringBootApplication(scanBasePackages = "com.urlshortener")
@EnableWebFlux
public class ShortenerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortenerServiceApplication.class, args);
    }
}
