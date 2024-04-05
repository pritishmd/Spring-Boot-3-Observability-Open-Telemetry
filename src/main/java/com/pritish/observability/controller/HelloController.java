package com.pritish.observability.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloController {

    private final RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        log.info("----------Hello method started--------------");
        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("https://httpbin.org/post","Hello, Cloud!", String.class);
        log.info("--------------Response : {}",responseEntity.getBody());
        return responseEntity.getBody();
    }
}
