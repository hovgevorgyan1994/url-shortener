package com.urlshortener.application.service;

import com.urlshortener.application.service.dto.ShortenUrlCommand;
import com.urlshortener.application.service.dto.UrlShortenedResponse;
import com.urlshortener.application.service.exception.UrlException;
import com.urlshortener.application.service.mapper.ShortenerMapper;
import com.urlshortener.application.service.ports.input.UrlShortenerApplicationService;
import com.urlshortener.application.service.ports.output.CountryIdentifier;
import com.urlshortener.application.service.ports.output.UrlEntityRepository;
import com.urlshortener.application.service.ports.output.UrlMessagePublisher;
import com.urlshortener.domain.UrlDomainService;
import com.urlshortener.domain.entity.Url;
import com.urlshortener.domain.event.UrlShortenedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlShortenerApplicationServiceImpl implements UrlShortenerApplicationService {
    private final ShortenerMapper shortenerMapper;
    private final UrlMessagePublisher messagePublisher;
    private final UrlEntityRepository urlEntityRepository;
    private final CountryIdentifier countryIdentifier;
    private final UrlDomainService urlDomainService;

    @Override
    public UrlShortenedResponse shorten(ShortenUrlCommand shortenUrlCommand) {
        var country = countryIdentifier.identify(shortenUrlCommand.ipAddress());
        if (log.isInfoEnabled()) {
            log.info("Attempt from {} to shorten url: {}", country, shortenUrlCommand.url());
        }

        var requestDetails = shortenerMapper.shortenCommandToRequestDetails(shortenUrlCommand, country);
        var url = shortenerMapper.shortenCommandToUrl(shortenUrlCommand);
        UrlShortenedEvent shortenedEvent = urlDomainService.shorten(url, requestDetails);

        Url savedUrl = urlEntityRepository.persist(url);
        if (savedUrl == null) {
            log.error("Could not save url from request: {}", shortenUrlCommand);
            throw new UrlException("Could not save url from request: " + shortenUrlCommand);
        }

        messagePublisher.publish(shortenedEvent);
        return shortenerMapper.urlToResponse(url);
    }
}
