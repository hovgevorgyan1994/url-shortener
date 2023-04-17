package com.urlshortener.metric.service.domain.application.service.ports.output;

import com.urlshortener.metric.service.domain.core.entity.RequestDetailsEntity;

public interface MetricRepository {
    void saveMetrics(RequestDetailsEntity requestDetails);
}
