package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void create() {
        User user = User.of(123L, "jang", 26);

        assertThat(user.getId()).isEqualTo(123L);
        assertThat(user.getName()).isEqualTo("jang");
        assertThat(user.getAge()).isEqualTo(26);
    }
}