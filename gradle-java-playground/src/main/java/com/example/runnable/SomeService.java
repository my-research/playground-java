package com.example.runnable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeService {
    private final SomeRepository repository;

    public Some doSomething() {
        return repository.find();
    }

    public void doSomething2() {
        Some some = repository.find();

        some.change();
    }
}
