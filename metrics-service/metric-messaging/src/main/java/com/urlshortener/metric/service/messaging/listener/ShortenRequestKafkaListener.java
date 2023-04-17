package com.urlshortener.metric.service.messaging.listener;

import java.util.List;

import com.urlshortener.kafka.avro.model.ShortenRequestAvroModel;
import com.urlshortener.kafka.consumer.KafkaConsumer;
import com.urlshortener.metric.service.domain.application.service.ports.input.ShortenRequestMessageListener;
import com.urlshortener.metric.service.messaging.mapper.ShortenRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShortenRequestKafkaListener implements KafkaConsumer<ShortenRequestAvroModel> {

    private final ShortenRequestMessageListener messageListener;
    private final ShortenRequestMapper requestMapper;

    @Override
    @KafkaListener(
        id = "${kafka-consumer-config.shorten-consumer-group-id}",
        topics = "${shortener-service.shorten-request-topic-name}")
    public void receive(@Payload List<ShortenRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of shorten requests received with keys:{}, partitions:{} and offsets: {}",
                 messages.size(),
                 keys.toString(),
                 partitions.toString(),
                 offsets.toString());
        messages.forEach(avroModel -> messageListener.saveMetrics(requestMapper.avroModelToRequestDetails(avroModel)));
    }
}
