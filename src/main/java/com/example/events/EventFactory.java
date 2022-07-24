package com.example.events;

import com.example.domain.Inventory;
import com.example.domain.Item;
import com.example.domain.Items;

public class EventFactory {
    public static JoinedEvent join(Long id, String name, Inventory inventory) {
        String message = String.format("User Joined !! => [%s] [%s] [%s]", id, name, inventoryToString(inventory));
        System.out.println("message = " + message);
        return JoinedEvent.by(id, name, inventory);
    }

    private static String inventoryToString(Inventory inventory) {
        StringBuilder sb = new StringBuilder();
        Items items = inventory.getItems();
        Item[] itemArray = items.getItems();
        for (Item item : itemArray) {
            sb.append("item: ").append(item).append(", ");
        }
        return sb.toString();
    }
}
