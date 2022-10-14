package com.example.lombok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void name() {
        User user = new User("old", "old");

        user.withUsername("new");
        System.out.println("aNew = " + user);
    }
}