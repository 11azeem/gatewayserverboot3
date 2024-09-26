package com.cbt.gatewayserverboot3.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public Mono<String> index() {
        Resource resource = new ClassPathResource("static/index.html");
        try {
            byte[] bytes = resource.getInputStream().readAllBytes();
            return Mono.just(new String(bytes, StandardCharsets.UTF_8));
        } catch (IOException e) {
            return Mono.just("<html><body><h1>Error loading index.html</h1></body></html>");
        }
    }
}


