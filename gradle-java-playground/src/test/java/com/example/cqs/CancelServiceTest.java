package com.example.cqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CancelServiceTest {

    CancelService sut = new CancelService();

    /**
     * 기대하는 행위
     * 1. Command 에 포함된 memberId 로 member 를 조회하고 terminate() 시켜라
     * 2. Command 에 포함된 walletId 로 wallet 을 조회하고 ticketClear() 시켜라
     */
    @Test
    void name() {
        CancelCommand command = CancelCommand.of(1L, 2L);

        sut.cancel(command);
    }

    @Test
    void name2() {
        CancelCommand command = CancelCommand.of(1L, 2L);

        assertDoesNotThrow(() -> sut.cancel(command));
    }
}