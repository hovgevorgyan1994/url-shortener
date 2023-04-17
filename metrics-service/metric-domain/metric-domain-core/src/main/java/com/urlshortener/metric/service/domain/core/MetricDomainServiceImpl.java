package com.urlshortener.metric.service.domain.core;

import static java.time.LocalDateTime.from;

import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;
import com.urlshortener.metric.service.domain.core.entity.RequestDetailsEntity;

public class MetricDomainServiceImpl implements MetricDomainService {
    @Override
    public RequestDetailsEntity toDetailsEntity(ShortenRequestDetails details) {
        return new RequestDetailsEntity(details.getId(), details.getUrl(), details.getExpiresAt(),
                                        details.getIpAddress(), details.getCountry(), from(details.getZonedDateTime()));
    }
}
