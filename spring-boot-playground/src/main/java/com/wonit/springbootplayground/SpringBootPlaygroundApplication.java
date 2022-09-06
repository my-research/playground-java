package com.wonit.springbootplayground;

import java.lang.reflect.Method;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootPlaygroundApplication.class, args);

        Map<String, Object> beans = run.getBeansWithAnnotation(SomeAnnotation.class);

        for (String s : beans.keySet()) {
            System.out.println("s = " + s);
        }
    }
}
