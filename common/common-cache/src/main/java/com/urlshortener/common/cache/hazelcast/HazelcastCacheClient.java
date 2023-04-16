package com.urlshortener.common.cache.hazelcast;

import static java.util.UUID.randomUUID;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.urlshortener.common.cache.CacheClient;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Scope("prototype")
public class HazelcastCacheClient<K extends Serializable, V extends Serializable> implements CacheClient<K, V> {
    private final IMap<K, V> cache;

    public HazelcastCacheClient(HazelcastInstance commonCacheInstance) {
        this.cache = commonCacheInstance.getMap(randomUUID() + "_cache");
    }

    @Override
    public Mono<V> cache(@NonNull K key, @NonNull V value) {
        return Mono.fromCompletionStage(cache.putAsync(key, value));
    }

    @Override
    public Mono<V> cache(@NonNull K key, @NonNull V value, long expiration) {
        return Mono.fromCompletionStage(cache.putAsync(key, value, expiration, TimeUnit.MINUTES));
    }

    @Override
    public Mono<V> cache(@NonNull K key, @NonNull V value, long expiration, @NonNull TimeUnit timeUnit) {
        return Mono.fromCompletionStage(cache.putAsync(key, value, expiration, timeUnit));
    }

    @Override
    public Mono<V> get(@NonNull K key) {
        return Mono.fromCompletionStage(cache.getAsync(key));
    }
}
