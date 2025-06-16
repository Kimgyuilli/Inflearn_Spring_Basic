package com.example.inflearn_spring_basic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // Request scope for web applications
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] " + requestURL + " " + message);
    }
    @PostConstruct
    public void init() {
        // Generate a unique identifier for the request
        uuid = java.util.UUID.randomUUID().toString();
        System.out.println("MyLogger initialized: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("MyLogger closed: " + this);
    }
}
