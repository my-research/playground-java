package com.example.poc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ATest {

    A sut = new A();

    @Test
    void name() {
        sut.printEnv();
        EnvChecker.setEnvToTest();
        sut.printEnv();
        EnvChecker.rollback();
        sut.printEnv();
    }
}