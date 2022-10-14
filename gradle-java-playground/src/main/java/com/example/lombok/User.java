package com.example.lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @With
    String username;
    @With
    String address;
}
