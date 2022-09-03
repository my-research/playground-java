package com.example.anno;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = User.class.getAnnotations();

        System.out.println("size" + annotations.length);
    }
}
