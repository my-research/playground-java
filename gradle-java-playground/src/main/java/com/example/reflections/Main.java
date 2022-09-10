package com.example.reflections;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Reflector reflector = new Reflector();

        Object o = reflector.get();

        Method method = o.getClass().getMethod("describe", String.class);

        method.invoke(o, "audi");
    }
}
