package com.example.demo.event;

import com.spg.uccs.configurator.domain.WebhookAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class WebhookEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  public WebhookEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishWebhookEvent(final List<String> conversionNames, final WebhookAction webhookAction) {
    log.debug("Publishing webhook event");
    WebhookEvent webhookEvent = new WebhookEvent(this, conversionNames, webhookAction);
    applicationEventPublisher.publishEvent(webhookEvent);
  }
}
