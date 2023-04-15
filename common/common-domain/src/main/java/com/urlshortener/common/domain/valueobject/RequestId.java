package com.urlshortener.common.domain.valueobject;

import java.util.UUID;

public class RequestId extends BaseId<UUID> {
    public RequestId(UUID value) {
        super(value);
    }
}
