package com.urlshortener.metric.service.dataaccess;

import static com.urlshortener.metric.service.dataaccess.mapper.RequestDetailsMapper.toPersistentEntity;

import com.urlshortener.metric.service.dataaccess.repository.MetricJpaRepository;
import com.urlshortener.metric.service.domain.application.service.ports.output.MetricRepository;
import com.urlshortener.metric.service.domain.core.entity.RequestDetailsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MetricRepositoryImpl implements MetricRepository {

    private final MetricJpaRepository metricJpaRepository;

    @Override
    public void saveMetrics(RequestDetailsEntity requestDetails) {
        metricJpaRepository.save(toPersistentEntity(requestDetails));
    }
}
