package com.urlshortener.shortener.service.application.service;

import com.urlshortener.shortener.service.application.service.dto.ShortenUrlCommand;
import com.urlshortener.shortener.service.application.service.mapper.ShortenerMapper;
import com.urlshortener.shortener.service.application.service.ports.input.RequestPublishingService;
import com.urlshortener.shortener.service.application.service.ports.output.CountryIdentifier;
import com.urlshortener.shortener.service.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.shortener.service.domain.UrlDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestPublishingServiceImpl implements RequestPublishingService {

    private final CountryIdentifier countryIdentifier;
    private final UrlDomainService urlDomainService;
    private final ShortenerMapper shortenerMapper;
    private final UrlMessagePublisher messagePublisher;

    @Override
    public Mono<Void> publishRequest(ShortenUrlCommand shortenUrlCommand) {
        return Mono.just(shortenUrlCommand)
            .flatMap(command -> countryIdentifier.identify("5.134.80.0")
                .map(country -> shortenerMapper.shortenCommandToRequestDetails(command, country))
                .flatMap(requestDetails -> {
                    var url = shortenerMapper.shortenCommandToUrl(command);
                    return messagePublisher.publish(urlDomainService.shorten(url, requestDetails));
                }));
    }
}