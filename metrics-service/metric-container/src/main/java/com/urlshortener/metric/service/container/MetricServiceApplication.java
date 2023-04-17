package com.urlshortener.metric.service.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.urlshortener")
@EntityScan(basePackages = "com.urlshortener.metric.service.dataaccess")
@EnableJpaRepositories(basePackages = "com.urlshortener.metric.service.dataaccess")
public class MetricServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetricServiceApplication.class, args);
    }
}
