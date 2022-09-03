package com.wonit.springbootplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootPlaygroundApplication.class, args);

        Processor processor = run.getBean("processor", Processor.class);

        processor.run();
    }
}
