package com.example.reflections;

public class FancyStringCreator implements Creator<String> {
    public String create(String aa) { return "this is fancy string creator" + aa; }
}