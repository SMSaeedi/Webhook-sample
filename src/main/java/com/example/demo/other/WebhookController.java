//package com.example.demo;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/wehook")
//public class WebhookController {
//
//
//    public void createWebHookEndPoint() {
//        Stripe.apiKey = "sk_test_4eC39HqLyjWDarjtT1zdp7dc";
//
//        List<Object> enabledEvents = new ArrayList<>();
//        enabledEvents.add("charge.failed");
//        enabledEvents.add("charge.succeeded");
//        Map<String, Object> params = new HashMap<>();
//        params.put("url", "https://example.com/my/webhook/endpoint");
//        params.put("enabled_events", enabledEvents);
//
//        WebHookEndPoint webhookEndpoint = WebHookEndPoint.create(params);
//    }
//
//    private static class Stripe {
//        static String apiKey;
//    }
//}