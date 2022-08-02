package com.wonit.springbootplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "named_objectMapper")
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public WrappedMapper wrappedMapper(ObjectMapper objectMapper) {
        return new WrappedMapper(objectMapper);
    }
}
