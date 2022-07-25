package com.example.poc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class SomeTargetTest {

    SomeTarget sut = SomeTarget.create();

    @Test
    void name0() {
        SomeTarget someTarget = mock(SomeTarget.class);
    }

    @Test
    void name() {
        sut.printEnv();
        EnvChecker.setEnvToTest();
        sut.printEnv();
        EnvChecker.rollback();
        sut.printEnv();
    }

    @Test
    void using_lib() {
        MockedStatic<EnvChecker> mockedStatic = mockStatic(EnvChecker.class);

        given(EnvChecker.checkEnv()).willReturn("xx");

        sut.printEnv();

        mockedStatic.close();
    }

    @Test
    void name2() {
        given(EnvChecker.checkEnv()).willReturn("xx");

        sut.printEnv();
    }
}