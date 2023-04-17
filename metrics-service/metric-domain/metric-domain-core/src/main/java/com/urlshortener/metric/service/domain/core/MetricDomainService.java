package com.urlshortener.metric.service.domain.core;

import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;
import com.urlshortener.metric.service.domain.core.entity.RequestDetailsEntity;

public interface MetricDomainService {

    RequestDetailsEntity toDetailsEntity(ShortenRequestDetails requestDetails);
}
