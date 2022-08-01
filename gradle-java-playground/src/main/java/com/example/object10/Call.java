package com.example.object10;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Call {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Duration getDuration() {
        return Duration.between(from, to);
    }
}
