//package com.example.demo;
//
//import com.svix.Svix;
//import com.svix.exceptions.ApiException;
//import com.svix.models.ApplicationIn;
//import com.svix.models.ApplicationOut;
//import com.svix.models.MessageIn;
//import com.svix.models.MessageOut;
//
//public class CreateApplication {
//
//    public static ApplicationOut createAnApplicationPerUser() {
//        Svix svix = new Svix("AUTH_TOKEN");
//        ApplicationOut app;
//
//        {
//            try {
//                app = svix.getApplication().create(new ApplicationIn().name("Application name"));
//            } catch (ApiException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return app;
//    }
//
//    public static MessageOut sendMessage() {
//        Svix svix = new Svix("AUTH_TOKEN");
//        try {
//            return svix.getMessage().create("app_Xzx8bQeOB1D1XEYmAJaRGoj0",
//                    new MessageIn()
//                            .eventType("invoice.paid")
//                            .eventId("evt_Wqb1k73rXprtTm7Qdlr38G")
//                            .payload("{" +
//                                    "\"id\": \"invoice_WF7WtCLFFtd8ubcTgboSFNql\"," +
//                                    "\"status\":  \"paid\"," +
//                                    "\"attempt\": 2" +
//                                    "}"));
//        } catch (ApiException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void main(String[] args) {
//        createAnApplicationPerUser();
//    }
//}
