package com.wonit.springbootplayground;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SomeController {

    private final SomeService service;

    @GetMapping("/")
    public String hh() {
        service.hello();
        return "success";
    }

}
