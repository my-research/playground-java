package com.example.events;

import com.example.User;
import lombok.Getter;
import lombok.Value;

@Getter
public class JoinedEvent {

    public static JoinedEvent by(Long id, String name, int age) {
        return new JoinedEvent(id, name, age);
    }

    private final Long id;
    private final String name;
    private final int age;

    private JoinedEvent(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
