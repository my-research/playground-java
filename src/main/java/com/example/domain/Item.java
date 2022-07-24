package com.example.domain;

import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
public class Item {
    String name;
}
