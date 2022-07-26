package com.example.poc2.util;

import java.time.LocalDateTime;

public class Clocks implements Clock {

    private static Clock INSTANCE;
    private static final Clock SYSTEM_CLOCK = new SystemClock();

    static {
        INSTANCE = SYSTEM_CLOCK;
    }

    public static LocalDateTime now() {
        return INSTANCE.getNow();
    }


    public static void setFakeClockBy(LocalDateTime fakeDate) {
        INSTANCE = new FakeClock(fakeDate);
    }

    public static void rollback() {
        INSTANCE = SYSTEM_CLOCK;
    }

    @Override
    public LocalDateTime getNow() {
        return null;
    }

    private static final class SystemClock implements Clock {

        @Override
        public LocalDateTime getNow() {
            return LocalDateTime.now();
        }
    }

    private static final class FakeClock implements Clock {

        private final LocalDateTime fakeDateTime;

        private FakeClock(LocalDateTime fakeDateTime) {
            this.fakeDateTime = fakeDateTime;
        }

        @Override
        public LocalDateTime getNow() {
            return fakeDateTime;
        }
    }
}
