package com.example.demo.controller;

import com.example.demo.domain.Webhook;
import com.example.demo.dto.WebHookDto;
import com.example.demo.enums.WebhookAction;
import com.example.demo.service.WebhookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {
    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping
    public WebHookDto createWebhook(@RequestBody WebHookDto webHookDto) {
        return webhookService.create(webHookDto);
    }

    @PutMapping("/{id}")
    public WebHookDto updateWebhook(@PathVariable("id") String id,
                                    @RequestBody WebHookDto webHookDto) {
        return webhookService.update(id, webHookDto);
    }

    @GetMapping("/{id}")
    public WebHookDto getWebhookById(@PathVariable("id") String id) {
        return webhookService.findById(id);
    }

    @GetMapping("/{action}")
    public Webhook getWebhookAction(@PathVariable("action") WebhookAction action) {
        return webhookService.findByAction(action);
    }

    @GetMapping
    public List<WebHookDto> getAllWebhooks() {
        return webhookService.findAll();
    }
}