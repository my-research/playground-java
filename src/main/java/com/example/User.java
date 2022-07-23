package com.example;

import com.example.events.EventFactory;
import com.example.events.JoinedEvent;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
public class User {

    public static User of(Long id, String name, int age) {
        JoinedEvent join = EventFactory.join(id, name, age);
        System.out.println("User Joined!! => " + join);
        return new User(id, name, age);
    }

    private final long id;
    private final String name;
    private final int age;

    private User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
