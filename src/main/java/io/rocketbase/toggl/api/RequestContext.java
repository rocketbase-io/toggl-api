package io.rocketbase.toggl.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class RequestContext {

    private final TogglApiBuilder apiBuilder;
    private RestTemplate restTemplate;
    private String basicAuth = null;

    RequestContext(TogglApiBuilder apiBuilder) {
        this.apiBuilder = apiBuilder;

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter(getObjectMapper())));
    }


    protected ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        return mapper;
    }

    protected String getBasicAuth() {
        if (basicAuth == null) {
            String auth = apiBuilder.getApiToken() + ":api_token";
            basicAuth = new String(Base64.encodeBase64(auth.getBytes()));
        }
        return basicAuth;
    }

    public UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromUriString(String.format("https://%s", apiBuilder.getHost()));
    }

    public synchronized <E> E execute(UriComponentsBuilder uriBuilder, HttpMethod httpMethod, ParameterizedTypeReference<E> entityClass) throws IOException, URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add(HttpHeaders.ACCEPT_ENCODING, "application/gzip");
        headers.add("Authorization", "Basic " + getBasicAuth());

        uriBuilder.queryParam("user_agent", apiBuilder.getUserAgent());

        HttpEntity<E> httpEntity = new HttpEntity<E>(headers);
        ResponseEntity<E> response = restTemplate.exchange(uriBuilder.toUriString(), httpMethod, httpEntity, entityClass);


        return response.getBody();
    }

}
