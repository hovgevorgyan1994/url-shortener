package com.urlshortener.metric.service.dataaccess.mapper;

import static lombok.AccessLevel.PRIVATE;

import com.urlshortener.metric.service.dataaccess.entity.RequestDetails;
import com.urlshortener.metric.service.domain.core.entity.RequestDetailsEntity;
import com.urlshortener.metric.service.domain.core.valueobject.DetailsEntityId;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class RequestDetailsMapper {

    public static RequestDetails toPersistentEntity(RequestDetailsEntity entity) {
        return RequestDetails.builder()
            .id(entity.getId().getValue())
            .urlId(entity.getUrlId())
            .url(entity.getUrl())
            .expiresAt(entity.getExpiresAt())
            .ipAddress(entity.getIpAddress())
            .country(entity.getCountry())
            .zonedDatetime(entity.getZonedDatetime())
            .build();
    }

    public static RequestDetailsEntity toDomainEntity(RequestDetails details) {
        var requestDetailsEntity =
            new RequestDetailsEntity(details.getUrlId(),
                                     details.getUrl(),
                                     details.getExpiresAt(), details.getIpAddress(), details.getCountry(),
                                     details.getZonedDatetime());
        requestDetailsEntity.setId(new DetailsEntityId(details.getId()));
        return requestDetailsEntity;
    }
}
