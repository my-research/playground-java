package com.example.demo;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/")
    public String test(@RequestBody Map<String, String> req) {
        String phoneNumber = req.get("phoneNumber");
        System.out.println("phoneNumber = " + phoneNumber);

        return "";
    }
}
