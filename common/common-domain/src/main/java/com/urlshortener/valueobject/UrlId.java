package com.urlshortener.valueobject;

import java.util.UUID;

public class UrlId extends BaseId<UUID> {
    public UrlId(UUID value) {
        super(value);
    }
    public UrlId(){}
}
