package com.emrops.cdecodes.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VersionController {
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/api/v1/version") //Return deployed version of app
    public Map<String, String> getStatus() {
        Map<String, String> status = new HashMap<String, String>();
        status.put("app-version", appVersion);
        return status;
    }

}



