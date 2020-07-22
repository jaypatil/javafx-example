package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyApiImpl implements ThirdPartyApi {

    private static final String RESOURCE_PATH = "/rest/employees";
    private Logger LOG = LoggerFactory.getLogger(ThirdPartyApiImpl.class);
    private String REQUEST_URI = "https://www.google.com";
    private RestTemplate restTemplate;

    @Autowired
    public ThirdPartyApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getData() {
        ResponseEntity<String> entity = restTemplate.getForEntity(REQUEST_URI, String.class);
        LOG.info("Status code value: " + entity.getStatusCodeValue());
        LOG.info("HTTP Header 'ContentType': " + entity.getHeaders().getContentType());
        return entity.getBody();
    }
}
