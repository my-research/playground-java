package com.example.events;

import com.example.domain.Inventory;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class JoinedEvent {

    public static JoinedEvent by(Long id, String name, Inventory inventory) {
        return new JoinedEvent(id, name, inventory);
    }

    private final Long id;
    private final String name;
    private final Inventory inventory;

    private JoinedEvent(Long id, String name, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
    }
}
