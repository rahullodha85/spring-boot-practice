package com.example.demo.info;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {
    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.version}")
    private String version;

    public String getName() { return name; }
    public String getVersion() { return version; }
}