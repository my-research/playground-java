package com.example.anno;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SerializerTest {

    Serializer sut;

    Order order;

    @BeforeEach
    void setUp() {
        OrderItem notebook = OrderItem.builder()
                .id(ZonedDateTime.now().toEpochSecond())
                .name("notebook")
                .price(310000)
                .build();

        OrderItem tv = OrderItem.builder()
                .id(ZonedDateTime.now().toEpochSecond())
                .name("tv")
                .price(310000)
                .build();

        order = Order.builder()
                .id(123L)
                .userId(UUID.randomUUID().toString())
                .orderItems(List.of(notebook, tv))
                .build();

        sut = new Serializer();
    }

    @Test
    void name() throws Exception {
        byte[] serialized = sut.serialize(order);
        System.out.println("serialized = " + Base64.getEncoder().encodeToString(serialized));

        Order2 order = sut.deserialize(serialized);
        System.out.println("order = " + order);
    }

    @Test
    void name2() {
        Gson gson = new Gson();

        String json = gson.toJson(order);

        System.out.println("json = " + json);
        String json1 = gson.toJson(new OrderEvent(1L, "asdf",
                "{\"id\":123,\"userId\":\"f42848d4-a1bf-470d-a468-156980169d3e\",\"orderItems\":[{\"id\":1663416190,\"name\":\"notebook\",\"price\":310000},{\"id\":1663416190,\"name\":\"tv\",\"price\":310000}]}"));

        System.out.println("json1 = " + json1);
        OrderEvent orderEvent = gson.fromJson(json1, OrderEvent.class);

        System.out.println("orderEvent = " + orderEvent);
    }
}