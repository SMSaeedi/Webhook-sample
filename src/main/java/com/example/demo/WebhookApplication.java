package com.example.demo;

import com.example.demo.enums.WebhookAction;
import com.example.demo.event.WebhookEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WebhookApplication {

    @Autowired
    static
    private WebhookEventPublisher webhookEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(WebhookApplication.class, args);
        webhookEventPublisher.publishWebhookEvent(List.of(), WebhookAction.UPDATE);
    }

}