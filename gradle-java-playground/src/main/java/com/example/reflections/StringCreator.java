package com.example.reflections;

public class StringCreator implements Creator<String> {

    private final String a;

    public StringCreator(String a) {
        this.a = a;
    }

    public String create(String a) { return "this is simple string creator"; }
}