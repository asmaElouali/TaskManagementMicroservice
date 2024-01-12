package com.example.microservicenote.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @Value("${app.version}")
    private String version;

    @GetMapping("/version")
    public String getVersion() {
        return "Application is running with"+" "+version;
    }
}
