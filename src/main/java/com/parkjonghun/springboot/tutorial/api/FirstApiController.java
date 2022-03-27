package com.parkjonghun.springboot.tutorial.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController { // JSON을 반환하는 컨트롤러

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}
