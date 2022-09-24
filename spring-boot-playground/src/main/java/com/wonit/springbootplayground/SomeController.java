package com.wonit.springbootplayground;

import com.github.dhslrl321.zsmq.client.ZolaQueueMessageTemplate;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SomeController {

    private final ApplicationContext context;

    @GetMapping("/hello")
    public void hello() {
        Map<String, Object> beansWithAnnotation =
                context.getBeansWithAnnotation(SomeAnnotation.class);

        for (String s : beansWithAnnotation.keySet()) {
            System.out.println("s = " + s);
        }

        System.out.println("called " + true);
    }
}
