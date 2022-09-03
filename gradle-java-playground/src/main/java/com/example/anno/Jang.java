package com.example.anno;

@User
public class Jang implements Person {
    @Override
    public void greet() {
        System.out.println("this is jang");
    }
}
