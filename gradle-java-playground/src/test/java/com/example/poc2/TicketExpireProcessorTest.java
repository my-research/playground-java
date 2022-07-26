package com.example.poc2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

import com.example.poc2.util.Clocks;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class TicketExpireProcessorTest {

    private final static LocalDateTime _2022_05_31 = LocalDateTime.of(2022, 5, 31, 23, 59, 59);
    private final static LocalDateTime _2022_04_21 = LocalDateTime.of(2022, 4, 21, 23, 59, 59);

    TicketExpireProcessor sut;

    @BeforeEach
    void setUp() {
        sut = new TicketExpireProcessor();
    }

    @Test
    void 오늘이_2022_05_31_이후라면_티켓이_만료된다() {
        sut = new TicketExpireProcessor();

        Ticket ticket = new Ticket(_2022_05_31);

        boolean isTerminated = sut.doProcess(ticket);
        assertThat(isTerminated).isTrue();
    }

    @Test
    void 오늘이_2022_05_31_이전이라면_티켓은_만료되지_않는다() {
        Clocks.setFakeClockBy(_2022_04_21);

        sut = new TicketExpireProcessor();

        Ticket ticket = new Ticket(_2022_05_31);

        boolean isTerminated = sut.doProcess(ticket);
        assertThat(isTerminated).isFalse();

        Clocks.rollback();
    }

    @Test
    void 오늘이_2022_05_31_이전이라면_티켓은_만료되지_않는다_lib() {
        MockedStatic<LocalDateTime> mockedStatic = mockStatic(LocalDateTime.class);
        given(LocalDateTime.now()).willReturn(_2022_04_21);

        Ticket ticket = new Ticket(_2022_05_31);

        boolean isTerminated = sut.doProcess(ticket);

        assertThat(isTerminated).isFalse();

        mockedStatic.close();
    }
}