package com.urlshortener.metric.service.container;

import com.urlshortener.metric.service.domain.core.MetricDomainService;
import com.urlshortener.metric.service.domain.core.MetricDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MetricDomainService metricDomainService(){
        return new MetricDomainServiceImpl();
    }
}
