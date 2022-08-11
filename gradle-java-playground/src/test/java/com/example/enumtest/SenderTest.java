package com.example.enumtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SenderTest {

    @Test
    void name() {
        SendingTypes sms = SendingTypes.valueOf("SMS");
        assertThat(SendingTypes.SMS).isEqualTo(sms);
    }
}