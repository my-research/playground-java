package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void name() {
        List<String> strings = List.of("a", "ab", "ac", "d", "e", "af");

        List<String> collect = strings.stream().filter(i -> !i.contains("a")).map(i -> "new: " + i)
                .collect(Collectors.toList());

        for (String s : collect) {
            System.out.println("s = " + s);
        }
    }

    @Test
    void name2() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("aes");
        SecretKey secretKey = keyGen.generateKey();
        String a = "hello world";


    }
}