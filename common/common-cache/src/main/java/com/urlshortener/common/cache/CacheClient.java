package com.urlshortener.common.cache;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

public interface CacheClient<K extends Serializable, V extends Serializable> {

    Mono<V> cache(@NonNull K key, @NonNull V value);

    Mono<V> cache(@NonNull K key, @NonNull V value, long expiration);

    Mono<V> cache(@NonNull K key, @NonNull V value, long expiration, @NonNull TimeUnit timeUnit);

    Mono<V> get(@NonNull K key);
}
