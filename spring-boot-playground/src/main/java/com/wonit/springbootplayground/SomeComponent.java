package com.wonit.springbootplayground;

import org.springframework.beans.factory.annotation.Value;

public class SomeComponent {
    public SomeComponent(@Value("${secret}") String scret) {
        System.out.println("secret = " + scret);
    }
}
