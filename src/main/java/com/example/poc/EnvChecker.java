package com.example.poc;

public class EnvChecker implements Checker {

    private static final Checker PRODUCTION;

    static {
        PRODUCTION = new Production();
    }

    private static Checker INSTANCE = PRODUCTION;

    @Override
    public void check() {
        INSTANCE.check();
    }

    public static void checkEnv() {
        INSTANCE.check();
    }

    public static void setEnvToTest() {
        INSTANCE = new Testing();
    }

    public static void rollback() {
        INSTANCE = new Production();
    }

    private static class Production implements Checker {

        @Override
        public void check() {
            System.out.println("this is production env");
        }
    }

    private static class Testing implements Checker {
        @Override
        public void check() {
            System.out.println("this is testing env");
        }
    }
}
