//package com.example.demo;
//
//import com.svix.Svix;
//import com.svix.exceptions.ApiException;
//import com.svix.models.DashboardAccessOut;
//
//import java.util.Map;
//
//public class WebHookEndPoint {
//    public static void addWebHookEndPoint() {
//        Svix svix = new Svix("AUTH_TOKEN");
//        DashboardAccessOut dashboard = null;
//        try {
//            dashboard = svix.getAuthentication().dashboardAccess("app_Xzx8bQeOB1D1XEYmAJaRGoj0");
//        } catch (ApiException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(dashboard.getUrl());
//    }
//
//    public static void main(String[] args) {
//        WebHookEndPoint.addWebHookEndPoint();
//    }
//
//    public static WebHookEndPoint create(Map<String, Object> params) {
//        return null;
//    }
//}
