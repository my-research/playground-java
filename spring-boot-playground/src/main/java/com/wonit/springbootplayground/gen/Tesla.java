package com.wonit.springbootplayground.gen;

import org.springframework.stereotype.Component;

@Component
public class Tesla implements Car {
    @Override
    public void drive() {
        System.out.println("tesla ~~ broong~~");
    }
}
