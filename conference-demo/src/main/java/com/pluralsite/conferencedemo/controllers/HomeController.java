package com.pluralsite.conferencedemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map<String, String> getStatus() {
        Map<String, String> status = new HashMap<String, String>();
        status.put("app-version", appVersion);
        return status;
    }

}

// @RestController
// public class HomeController {
//     @Value("${app.version}")
//     public String appVersion = "1.0.0";

//     @GetMapping
//     @RequestMapping("/")
//     public Map<String, String>  getStatus() {
//         Map<String, String> status = new HashMap<>();
//         status.put("app-version", appVersion);
//         return status;

//     }


// }



