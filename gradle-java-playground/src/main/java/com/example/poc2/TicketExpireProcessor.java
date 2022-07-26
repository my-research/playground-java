package com.example.poc2;

import com.example.poc2.util.Clocks;
import java.time.LocalDateTime;

public class TicketExpireProcessor {

    public boolean doProcess(Ticket ticket) {
        LocalDateTime now = Clocks.now();
        LocalDateTime ticketEndedAt = ticket.getEndedAt();

        if (now.isBefore(ticketEndedAt)) {
            return false;
        }
        ticket.expire();
        return true;
    }

}
