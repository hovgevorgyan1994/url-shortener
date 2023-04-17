package com.urlshortener.metric.service.messaging.mapper;

import java.time.LocalDateTime;

import com.urlshortener.kafka.avro.model.ShortenRequestAvroModel;
import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;
import org.springframework.stereotype.Component;

@Component
public class ShortenRequestMapper {

    public ShortenRequestDetails avroModelToRequestDetails(ShortenRequestAvroModel avroModel) {
        return ShortenRequestDetails.builder()
            .id(avroModel.getId())
            .url(avroModel.getUrl())
            .expiresAt(LocalDateTime.from(avroModel.getExpiresAat()))
            .ipAddress(avroModel.getIpAddress())
            .country(avroModel.getCountry())
            .zonedDateTime(avroModel.getZonedDateTime())
            .build();
    }
}
