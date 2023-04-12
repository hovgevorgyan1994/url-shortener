package com.urlshortener.country.identifier;


import com.urlshortener.application.service.ports.output.CountryIdentifier;
import org.springframework.stereotype.Service;

@Service
public class CountryIdentifierImpl implements CountryIdentifier {

    @Override
    public String identify(String ipAddress) {
        return null;
    }
}
