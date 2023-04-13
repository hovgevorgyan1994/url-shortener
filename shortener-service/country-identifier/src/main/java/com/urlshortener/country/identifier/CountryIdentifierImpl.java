package com.urlshortener.country.identifier;

import static java.net.http.HttpRequest.newBuilder;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;

import com.urlshortener.application.service.ports.output.CountryIdentifier;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryIdentifierImpl implements CountryIdentifier {
    private static final String COUNTRY_NAME = "country_name";
    private final HttpClient httpClient;
    private final CountryIdentifierConfig config;

    @Override
    public String identify(String ipAddress) {
        try {
            var request = newBuilder()
                .uri(URI.create(config.getIpStackUri(ipAddress)))
                .GET()
                .build();
            var jsonObject = new JSONObject(httpClient.send(request, ofString()).body());
            return jsonObject.getString(COUNTRY_NAME);
        } catch (IOException | InterruptedException | JSONException e) {
            return ipAddress;
        }
    }
}
