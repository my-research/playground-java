package com.wonit.springbootplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WrappedMapper {
    private final ObjectMapper objectMapper;

    public void hello() {

    }
}
