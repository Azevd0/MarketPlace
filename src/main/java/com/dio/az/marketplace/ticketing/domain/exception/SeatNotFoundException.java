package com.dio.az.marketplace.ticketing.domain.exception;

import com.dio.az.marketplace.ticketing.domain.event_domain.EventId;
import com.dio.az.marketplace.ticketing.domain.seat_domain.SeatId;

public class SeatNotFoundException extends RuntimeException{
    public SeatNotFoundException(EventId eventId, SeatId seatId){
        super("Seat with id "+ seatId + "not found.");
    }
}
