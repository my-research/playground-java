package com.wonit.springbootplayground;

import java.lang.annotation.Annotation;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Processor implements Runnable {

    @Autowired
    ApplicationContext context;

    @Override
    public void run() {
        while (true) {
            try {
                Map<String, SomeName> beansOfType = context.getBeansOfType(SomeName.class);

                System.out.println("beansOfType = " + beansOfType.size());
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
