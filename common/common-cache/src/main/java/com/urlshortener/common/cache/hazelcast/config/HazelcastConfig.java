package com.urlshortener.common.cache.hazelcast.config;

import static com.hazelcast.client.HazelcastClient.newHazelcastClient;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.List;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.SerializationConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {

    @Bean
    public HazelcastInstance commonCacheInstance(List<HazelCastSerializer<?>> cacheSerializers) {
        if (isEmpty(cacheSerializers)) {
            return null;
        }
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
