package com.wonit.springbootplayground;

import static org.assertj.core.api.Assertions.assertThat;

import com.wonit.springbootplayground.gen.Car;
import com.wonit.springbootplayground.gen.CarContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest

class SpringBootPlaygroundApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void 등록된_빈_조회() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        assertThat(beanNames).contains("beanConfig");
        assertThat(beanNames).contains("named_objectMapper");
        assertThat(beanNames).contains("wrappedMapper");
    }

    @Autowired
    CarContainer carContainer;

    @Test
    void name() {
        carContainer.getCars().forEach(Car::drive);
    }
}
