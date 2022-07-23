package com.example.events;

import com.example.User;

public class EventFactory {
    public static JoinedEvent join(Long id, String name, int age) {
        return JoinedEvent.by(id, name, age);
    }
}
