package com.urlshortener.metric.service.domain.core;

import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;
import com.urlshortener.metric.service.domain.core.entity.RequestDetailsEntity;

public class MetricDomainServiceImpl implements MetricDomainService {
    @Override
    public RequestDetailsEntity toDetailsEntity(ShortenRequestDetails details) {
        return new RequestDetailsEntity(details.getUrl(), details.getExpiresAt(),
                                        details.getIpAddress(), details.getCountry(), details.getZonedDatetime());
    }
}
