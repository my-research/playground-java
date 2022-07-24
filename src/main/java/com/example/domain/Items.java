package com.example.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Items {
    private final Item[] items;
}
