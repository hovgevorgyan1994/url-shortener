package com.urlshortener.metric.service.domain.core.valueobject;

import java.util.UUID;

import com.urlshortener.common.domain.valueobject.BaseId;

public class DetailsEntityId extends BaseId<UUID> {
    public DetailsEntityId(UUID value) {
        super(value);
    }
}
