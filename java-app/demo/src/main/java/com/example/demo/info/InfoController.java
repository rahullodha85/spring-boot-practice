package com.example.demo.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Autowired
    private AppProperties appProperties;

    @GetMapping
    public Info root() {
        return new Info(appProperties.getName(), appProperties.getVersion());
    }
}
