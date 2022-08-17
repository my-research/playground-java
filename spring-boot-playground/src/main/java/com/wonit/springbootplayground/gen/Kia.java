package com.wonit.springbootplayground.gen;

import org.springframework.stereotype.Component;

@Component
public class Kia implements Car {
    @Override
    public void drive() {
        System.out.println("kia ~~ broong~~");
    }
}
