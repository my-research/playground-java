package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.events.EventFactory;
import com.example.events.JoinedEvent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {

    @BeforeAll
    static void beforeAll() {
        EventFactory eventFactory = new EventFactory();
    }

    @Test
    void create_real_object() {
        User user = User.of(123L, "jang", 26);

        assertThat(user.getId()).isEqualTo(123L);
        assertThat(user.getName()).isEqualTo("jang");
        assertThat(user.getAge()).isEqualTo(26);
    }

    @Test
    void create_mock_object() {
        User user = User.of(123L, "jang", 26);

        assertThat(user.getId()).isEqualTo(123L);
        assertThat(user.getName()).isEqualTo("jang");
        assertThat(user.getAge()).isEqualTo(26);
    }
}