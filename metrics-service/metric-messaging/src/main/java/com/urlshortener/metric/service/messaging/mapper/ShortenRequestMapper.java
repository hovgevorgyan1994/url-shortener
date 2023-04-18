package com.urlshortener.metric.service.messaging.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.urlshortener.metric.service.domain.core.dto.ShortenRequestDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShortenRequestMapper {

    private final ObjectMapper objectMapper;

    public ShortenRequestDetails toRequestDetails(String shortenRequest) {
        try {
            return objectMapper.readValue(shortenRequest, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
