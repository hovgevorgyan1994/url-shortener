package com.urlshortener.application.service.cache.serilzier;

import static org.codehaus.jackson.smile.SmileParser.Feature.REQUIRE_HEADER;

import java.io.IOException;

import com.hazelcast.nio.serialization.ByteArraySerializer;
import lombok.Getter;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.smile.SmileFactory;

@Getter
public abstract class HazelCastSerializer<T> implements ByteArraySerializer<T> {
    private final Class<T> type;
    private final ObjectMapper mapper = new ObjectMapper(new SmileFactory().configure(REQUIRE_HEADER, false));

    public HazelCastSerializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public byte[] write(T t) throws IOException {
        return mapper.writeValueAsBytes(t);
    }

    @Override
    public T read(byte[] buffer) throws IOException {
        return mapper.readValue(buffer, type);
    }
}
