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

@Component
@Scope("prototype")
public class HazelcastCacheClient<K extends Serializable, V extends Serializable> implements CacheClient<K, V> {
    private final IMap<K, V> cache;

    public HazelcastCacheClient(HazelcastInstance commonCacheInstance) {
        this.cache = commonCacheInstance.getMap(randomUUID() + "_cache");
    }

    @Override
    public void cache(@NonNull K key, @NonNull V value) {
        cache.put(key, value);
    }

    @Override
    public void cache(@NonNull K key, @NonNull V value, long expiration) {
        cache.put(key, value, expiration, TimeUnit.MINUTES);
    }

    @Override
    public void cache(@NonNull K key, @NonNull V value, long expiration, @NonNull TimeUnit timeUnit) {
        cache.put(key, value, expiration, timeUnit);
    }

    @Override
    public V get(@NonNull K key) {
        return cache.get(key);
    }
}
