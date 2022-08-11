package com.example.consumer;

import lombok.Value;

@Value(staticConstructor = "of")
public class CustomConsumersRequest {
    String name;
}
