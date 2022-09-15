package com.example.demo.domain;

import com.example.demo.enums.WebhookAction;
import com.example.demo.enums.WebhookMethodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(collection = "webhook")
public class Webhook {

  @Id
  private String id;

  private String url;
  private String body;
  private String headers;
  private WebhookAction webhookAction;
  private WebhookMethodType webhookMethodType;
}
