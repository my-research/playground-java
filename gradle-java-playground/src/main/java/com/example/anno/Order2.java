package com.example.anno;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Order2 implements Serializable {
    Long id;
    String userId;
    List<OrderItem> orderItems;

    private static final long serialVersionUID = 1L;
}
