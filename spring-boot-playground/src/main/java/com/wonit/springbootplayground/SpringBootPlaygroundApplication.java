package com.wonit.springbootplayground;

import com.wonit.Greeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootPlaygroundApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootPlaygroundApplication.class, args);
        Greeter greeter = run.getBean("greeter", Greeter.class);
        greeter.greet();
    }
}
