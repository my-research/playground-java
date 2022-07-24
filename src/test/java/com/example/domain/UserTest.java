package com.example.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class UserTest {
    @Test
    void test_with_object() {
        Item[] items = new Item[2];
        items[0] = Item.of("weapon");
        items[1] = Item.of("portion");

        User actual = User.of(1L, "james", Inventory.of(Items.of(items), "default"));

        assertThat(actual).isNotNull();
    }

    @Test
    void test_with_mock() {
        Inventory inventory = mock(Inventory.class);

        User actual = User.of(1L, "james", inventory);

        assertThat(actual).isNotNull();
    }

    @Test
    void test_with_mock_with_mockito() {
        MockedStatic<User> mockedStatic = mockStatic(User.class);

        Inventory inventory = mock(Inventory.class);
        User USER = mock(User.class);

        given(User.of(1L, "james", inventory)).willReturn(USER);

        User actual = User.of(1L, "james", inventory);

        assertThat(actual).isNotNull();

        mockedStatic.close();
    }
}