package com.urlshortener.application.service.cache;

import static com.hazelcast.client.HazelcastClient.newHazelcastClient;

import java.util.List;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;
import com.urlshortener.application.service.cache.serilzier.HazelCastSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableCaching
@ConfigurationProperties(prefix = "hazelcast.cache")
public class CacheConfig {
    private int expiration;
    private String responseCache;
    private String urlCache;

    @Bean
    public HazelcastInstance urlCacheHazelcastInstance(List<HazelCastSerializer<?>> cacheSerializers) {
        var serializationConfig = new SerializationConfig();
        cacheSerializers.forEach(
            ser -> serializationConfig.addSerializerConfig(
                new SerializerConfig().setTypeClass(ser.getType()).setImplementation(ser)));

        var clientConfig = new ClientConfig();
        clientConfig.setSerializationConfig(serializationConfig);
        clientConfig.setProperty("hazelcast.client.config", "false");
        return newHazelcastClient(clientConfig);
    }
}
