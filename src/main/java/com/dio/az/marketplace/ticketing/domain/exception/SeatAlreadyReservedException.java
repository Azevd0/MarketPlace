package com.dio.az.marketplace.ticketing.domain.exception;

public class SeatAlreadyReservedException extends RuntimeException{
    public SeatAlreadyReservedException(){
        super("Seat is already reserved");
    }
}
