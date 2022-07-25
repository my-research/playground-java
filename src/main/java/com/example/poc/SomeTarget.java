package com.example.poc;

public class SomeTarget {

    private SomeTarget() {}

    public static SomeTarget create() {
        return new SomeTarget();
    }
    public void printEnv() {
        String env = EnvChecker.checkEnv();
        System.out.println(env);
    }

    public String ss() {
        return "null";
    }
}
