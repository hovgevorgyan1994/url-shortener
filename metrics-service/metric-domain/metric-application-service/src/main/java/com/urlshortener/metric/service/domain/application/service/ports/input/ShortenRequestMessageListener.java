package com.urlshortener.metric.service.domain.application.service.ports.input;

import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;

public interface ShortenRequestMessageListener {
    void saveMetrics(ShortenRequestDetails requestDetails);
}
