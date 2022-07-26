package com.example.poc;

public class EnvChecker implements Checker {

    private static final Checker PRODUCTION;

    static {
        PRODUCTION = new Production();
    }

    private static Checker INSTANCE = PRODUCTION;

    @Override
    public String check() {
        return INSTANCE.check();
    }

    public static String checkEnv() {
        return INSTANCE.check();
    }

    public static void setEnvToTest() {
        INSTANCE = new Testing();
    }

    public static void rollback() {
        INSTANCE = new Production();
    }

    private static class Production implements Checker {

        @Override
        public String check() {
            return "this is production env";
        }
    }

    private static class Testing implements Checker {
        @Override
        public String check() {
            return "this is testing env";
        }
    }
}
