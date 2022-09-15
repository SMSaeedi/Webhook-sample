package com.example.demo.client;

import com.example.demo.domain.Webhook;
import com.example.demo.enums.WebhookMethodType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RestTemplateClient {

    ObjectMapper mapper = new ObjectMapper();

    public void call(Webhook webhook) {
        HttpHeaders headers = getHeaders(webhook.getHeaders());
        HttpMethod method = webhook.getWebhookMethodType().equals(WebhookMethodType.GET) ? HttpMethod.GET : HttpMethod.POST;
        exchange(webhook.getUrl(), method, webhook.getBody(), headers);

        throw new RuntimeException("no such method found!");
    }

    private HttpHeaders getHeaders(String headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers == null)
            return httpHeaders;
        String[] headerElements = headers.split(",");
        for (String element : headerElements) {
            String[] keyValue = element.split(":");
            httpHeaders.put(keyValue[0], List.of(keyValue[1]));
        }

        return httpHeaders;
    }

    private <T> T exchange(String url, HttpMethod httpMethod, Object bodyRequest, HttpHeaders headers) {
        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.exchange(url, httpMethod, new HttpEntity<>(bodyRequest, headers), String.class);
        return getResult(response);
    }

    private <T> T getResult(ResponseEntity<String> response) {
        if (response.getStatusCode().is2xxSuccessful())
            return jsonToObject(response.getBody());
        throw new ResponseStatusException(response.getStatusCode(), response.getBody());
    }

    private <T> T jsonToObject(String json) {
        try {
            return (T) mapper.readValue(json, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
          try {
            throw new NoSuchFieldException(e.getMessage());
          } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
          }
        }
    }
}
