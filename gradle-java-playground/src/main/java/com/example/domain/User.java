package com.example.domain;

import com.example.events.EventFactory;
import com.example.events.JoinedEvent;
import lombok.Getter;

@Getter
public class User {

    public static User of(Long id, String name, Inventory inventory) {
        User user = new User(id, name, inventory);
        JoinedEvent join = EventFactory.join(id, name, inventory);
        return user;
    }

    private final long id;
    private final String name;
    private final Inventory inventory;

    public User(long id, String name, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
    }
}
