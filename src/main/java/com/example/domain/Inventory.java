package com.example.domain;

import lombok.Value;

@Value(staticConstructor = "of")
public class Inventory {
    Items items;
    String type;
}
