package com.example.runnable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class SomeServiceTest {

    SomeService sut;

    @Test
    void 행위() {
        SomeRepository repository = mock(SomeRepository.class);
        sut = new SomeService(repository);

        sut.doSomething();

        verify(repository).find();
    }

    @Test
    void 상태() {
        SomeRepository repository = mock(SomeRepository.class);
        sut = new SomeService(repository);

        Some actual = sut.doSomething();

        assertThat(actual).isNotNull();
    }
}