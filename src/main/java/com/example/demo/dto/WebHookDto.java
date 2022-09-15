package com.example.demo.dto;

import com.example.demo.enums.WebhookAction;
import com.example.demo.enums.WebhookMethodType;
import lombok.Data;

@Data
public class WebHookDto {
  private String url;
  private String body;
  private String headers;
  private WebhookAction webhookAction;
  private WebhookMethodType webhookMethodType;
}