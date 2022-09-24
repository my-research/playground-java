package com.example.anno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderEvent {
    Long id;
    String name;
    String orderItem;
}
