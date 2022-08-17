package com.example.reflections;

import java.lang.reflect.Constructor;

public class Reflections {
    public static void main(String[] args) throws Exception {

        Class<?> someClass = Class.forName("com.example.reflections.StringCreator");

        Class<? extends Creator> creatorClass = someClass.asSubclass(Creator.class);

        Constructor<? extends Creator> classConstructor = creatorClass.getConstructor((Class<?>[]) null);

        Creator<String> creator = (Creator<String>) classConstructor.newInstance("(Object[]) null");

        String s = creator.create("good");
        System.out.println("s = " + s);
    }
}
