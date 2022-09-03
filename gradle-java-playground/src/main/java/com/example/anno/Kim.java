package com.example.anno;

@User
public class Kim implements Person {

    @Override
    public void greet() {
        System.out.println("this is kim");
    }
}
