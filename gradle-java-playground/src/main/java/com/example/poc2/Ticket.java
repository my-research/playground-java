package com.example.poc2;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Ticket {

    private boolean isUsable;
    private final LocalDateTime endedAt;

    public Ticket(LocalDateTime endedAt) {
        isUsable = true;
        this.endedAt = endedAt;
    }

    public void expire() {
        isUsable = false;
    }
}
