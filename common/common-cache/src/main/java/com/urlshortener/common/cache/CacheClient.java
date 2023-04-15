package com.urlshortener.common.cache;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.lang.NonNull;

public interface CacheClient<K extends Serializable, V extends Serializable> {

    void cache(@NonNull K key, @NonNull V value);

    void cache(@NonNull K key, @NonNull V value, long expiration);

    void cache(@NonNull K key, @NonNull V value, long expiration, @NonNull TimeUnit timeUnit);

    V get(@NonNull K key);
}
