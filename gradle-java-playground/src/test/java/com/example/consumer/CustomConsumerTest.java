package com.example.consumer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomConsumerTest {

    @Test
    void name() {
        CustomConsumer consumer = new CustomConsumer();

        consumer.accept(CustomConsumersRequest.of("hello"));
    }
}