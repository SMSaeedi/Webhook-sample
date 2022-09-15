package com.example.demo.event;

import com.example.demo.enums.WebhookAction;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
public class WebhookEvent extends ApplicationEvent {
  private List<String> names;
  private WebhookAction webhookAction;

  public WebhookEvent(Object source, List<String> names, WebhookAction webhookAction) {
    super(source);
    this.names = names;
    this.webhookAction = webhookAction;
  }
}
