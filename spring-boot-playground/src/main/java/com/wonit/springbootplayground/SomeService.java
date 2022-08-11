package com.wonit.springbootplayground;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeService {
    @Value("${some-secret}")
    private String secret;

    public SomeService(@Value("${some-secret}") String scret) {
        System.out.println("secret = " + scret);
    }

    public void hello() {
        System.out.println("secret = " + secret);
    }
}
