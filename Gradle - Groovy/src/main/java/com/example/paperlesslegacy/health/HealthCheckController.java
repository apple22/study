package com.example.paperlesslegacy.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "UP");
        response.put("application", "paperless-legacy-javaee");
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("serverTime", LocalDateTime.now());
        return response;
    }
}