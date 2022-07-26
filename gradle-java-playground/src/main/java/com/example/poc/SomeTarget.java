package com.example.poc;

public class SomeTarget {

    private SomeTarget() {}

    public static SomeTarget create() {
        return new SomeTarget();
    }

    public String getEnv() {
        return EnvChecker.checkEnv();
    }
}
