package com.example.reflections;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Car {
    private final Engine engine;

    public void describe(String name) {
        String message = String.format("car name is %s, and has %s engine", name, engine.getName());
        System.out.println(message);
    }
}
