package com.urlshortener.metric.service.dataaccess.repository;

import java.util.UUID;

import com.urlshortener.metric.service.dataaccess.entity.RequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricJpaRepository extends JpaRepository<RequestDetails, UUID> {
}
