package com.urlshortener;

import com.urlshortener.domain.UrlDomainService;
import com.urlshortener.domain.UrlDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UrlDomainService urlDomainService() {
        return new UrlDomainServiceImpl();
    }
}
