package com.starzec.allegro.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class ProductProvider {
    private static final String RAPID_API_KEY = "X-RapidAPI-Key";
    private static final String RAPID_API_HOST = "X-RapidAPI-Host";
    private static final String PARAMETER = "parameters";
    private final RestTemplate restTemplate;
    private final String xRapidAPIKey;
    private final String xRapidAPIHost;


    public ProductProvider(RestTemplate restTemplate,
                           @Value("${app.providers.product.api-key}") String xRapidAPIKey,
                           @Value("${app.providers.product.api-host}") String xRapidAPIHost) {
        this.restTemplate = restTemplate;
        this.xRapidAPIKey = xRapidAPIKey;
        this.xRapidAPIHost = xRapidAPIHost;
    }

    public Optional<ProductResponse> findProductByEAN(final String EAN) {
        final String url = buildUrl(EAN);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(RAPID_API_KEY, xRapidAPIKey);
        httpHeaders.add(RAPID_API_HOST, xRapidAPIHost);
        try {
            ResponseEntity<ProductResponse> productResponse = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(PARAMETER, httpHeaders),
                    ProductResponse.class);
            //return productResponse.getBody();
            return Optional.of(productResponse.getBody());
        } catch (HttpClientErrorException e){
            log.warn("couldnt find product, because: {}", e.getMessage());
            return Optional.empty();
        }

    }

    private String buildUrl(String EAN) {
        //return "https://product-lookup-by-upc-or-ean.p.rapidapi.com/code/" + EAN;
        //return "https://"+xRapidAPIHost+"/code/" + EAN;
        return String.format("https://%s/code/%s", xRapidAPIHost, EAN);
    }


}
