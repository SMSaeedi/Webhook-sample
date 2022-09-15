package com.example.demo.event;

import com.example.demo.client.RestTemplateClient;
import com.example.demo.domain.Webhook;
import com.example.demo.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class WebhookEventListener implements ApplicationListener<WebhookEvent> {

  @Autowired
  private RestTemplateClient restTemplateClient;

  @Autowired
  private WebhookService webhookService;

  @Override
  public void onApplicationEvent(WebhookEvent webhookEvent) {
//    webhookEvent.getConversionNames();
//    webhookEvent.getWebhookAction();
    Webhook webhook = webhookService.findByAction(webhookEvent.getWebhookAction());
    restTemplateClient.call(webhook);
  }
}
