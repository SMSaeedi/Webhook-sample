package com.example.demo.repository;

import com.example.demo.domain.Webhook;
import com.example.demo.enums.WebhookAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebhookRepository extends MongoRepository<Webhook, String> {
  Optional<Webhook> findByWebhookAction(WebhookAction action);
}
