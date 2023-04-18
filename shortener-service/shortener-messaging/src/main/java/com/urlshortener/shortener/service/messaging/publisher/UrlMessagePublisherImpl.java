package com.urlshortener.shortener.service.messaging.publisher;

import com.urlshortener.kafka.avro.model.ShortenRequest;
import com.urlshortener.kafka.producer.service.KafkaProducer;
import com.urlshortener.shortener.service.application.service.config.ShortenerServiceConfigData;
import com.urlshortener.shortener.service.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.shortener.service.domain.event.UrlShortenedEvent;
import com.urlshortener.shortener.service.messaging.mapper.ShortenRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UrlMessagePublisherImpl implements UrlMessagePublisher {

    private final ShortenRequestMapper requestMapper;
    private final KafkaProducer<String, ShortenRequest> producer;
    private final ShortenerServiceConfigData configData;

    @Override
    public Mono<Void> publish(UrlShortenedEvent urlShortenedEvent) {
        return Mono.just(urlShortenedEvent)
            .doOnNext(event -> {
                var shortenRequest = requestMapper.eventToProtoModel(urlShortenedEvent);
                producer.send(configData.getShortenRequestTopicName(), shortenRequest.getUrlId(), shortenRequest);
            }).then();
    }
}
