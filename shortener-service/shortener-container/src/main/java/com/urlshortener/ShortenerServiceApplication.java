package com.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.urlshortener.dataaccess")
@SpringBootApplication(scanBasePackages = "com.urlshortener")
public class ShortenerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortenerServiceApplication.class, args);
    }
}
