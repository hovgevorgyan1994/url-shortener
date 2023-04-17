package com.urlshortener.shortener.service.container;

import com.urlshortener.shortener.service.domain.UrlDomainService;
import com.urlshortener.shortener.service.domain.UrlDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UrlDomainService urlDomainService() {
        return new UrlDomainServiceImpl();
    }
}
