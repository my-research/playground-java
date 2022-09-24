package com.example.anno;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem implements Serializable {
    Long id;
    String name;
    Integer price;
}
