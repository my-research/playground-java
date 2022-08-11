package com.example.consumer;

import java.util.function.Consumer;

public class CustomConsumer implements Consumer<CustomConsumersRequest> {
    @Override
    public void accept(CustomConsumersRequest customConsumersRequest) {
        System.out.println("consumed: " + customConsumersRequest);
    }
}
