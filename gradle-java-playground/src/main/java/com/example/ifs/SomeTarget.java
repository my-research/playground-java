package com.example.ifs;

import com.example.poc.EnvChecker;

public class SomeTarget {

    private SomeTarget() {}

    public static SomeTarget create() {
        return new SomeTarget();
    }

    public String getEnv() {
        return EnvChecker.checkEnv();
    }
}
