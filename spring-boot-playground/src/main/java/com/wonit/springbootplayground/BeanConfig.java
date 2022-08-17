package com.wonit.springbootplayground;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonit.springbootplayground.gen.Car;
import com.wonit.springbootplayground.gen.CarContainer;
import org.springframework.context.ApplicationContext;
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

    @Bean
    public CarContainer container(ApplicationContext context) {
        CarContainer carContainer = new CarContainer();
        Car kia = context.getBean("kia", Car.class);
        Car tesla = context.getBean("tesla", Car.class);
        carContainer.add(kia);
        carContainer.add(tesla);
        return carContainer;
    }
}
