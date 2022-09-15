package com.example.demo.service;

import com.example.demo.domain.Webhook;
import com.example.demo.dto.WebHookDto;
import com.example.demo.enums.WebhookAction;
import com.example.demo.repository.WebhookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WebhookService {
  @Autowired
  private WebhookRepository webhookRepository;

  @Autowired
  private ObjectMapper objectMapper;

  public WebHookDto create(WebHookDto newReq) {
    log.debug("Request to create a Webhook ", newReq);
    Webhook newWebhook = objectMapper.convertValue(newReq, Webhook.class);
    return objectMapper.convertValue(webhookRepository.save(newWebhook), WebHookDto.class);
  }

  public WebHookDto update(String id, WebHookDto updateReq) {
    log.debug("Request to update a Webhook", updateReq);
    Webhook updateWebHook = objectMapper.convertValue(updateReq, Webhook.class);
    updateWebHook.setId(id);
    return objectMapper.convertValue(webhookRepository.save(updateWebHook), WebHookDto.class);
  }

  public List<WebHookDto> findAll() {
    log.debug("Request to get all Webhooks");
    return objectMapper.convertValue(webhookRepository.findAll(), List.class);
  }

  public WebHookDto findById(String id) {
    log.debug("Request to get a Webhook by id ", id);
    Webhook findWebhookById = webhookRepository.findById(id).orElseThrow(() -> new RuntimeException("No such webhook found!"));
    return objectMapper.convertValue(findWebhookById, WebHookDto.class);
  }

  public Webhook findByAction(WebhookAction action) {
    log.debug("Request to get a Webhook action id ", action);
    return webhookRepository.findByWebhookAction(action).orElseThrow(() -> new RuntimeException("No such webhook found!"));
  }
}
