package com.urlshortener.metric.service.domain.application.service;

import com.urlshortener.metric.service.domain.application.service.ports.input.ShortenRequestMessageListener;
import com.urlshortener.metric.service.domain.application.service.ports.output.MetricRepository;
import com.urlshortener.metric.service.domain.core.MetricDomainService;
import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenRequestMessageListenerImpl implements ShortenRequestMessageListener {

    private final MetricDomainService metricDomainService;
    private final MetricRepository metricRepository;

    @Override
    public void saveMetrics(ShortenRequestDetails requestDetails) {
        var requestDetailsEntity = metricDomainService.toDetailsEntity(requestDetails);
        metricRepository.saveMetrics(requestDetailsEntity);
    }
}
