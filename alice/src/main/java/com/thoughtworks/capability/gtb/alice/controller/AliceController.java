package com.thoughtworks.capability.gtb.alice.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AliceController {
    private final RestTemplate restTemplate;

    public AliceController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/hello")
    public String sayHello() {
        String BOB_HELLO_URL = "http://bob:8081/hello";
        return restTemplate.getForObject(BOB_HELLO_URL, String.class);
    }

}
