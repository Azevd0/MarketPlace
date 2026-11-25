package com.dio.az.marketplace.ticketing.infrastructure.http;

import com.dio.az.marketplace.ticketing.domain.seat_domain.SeatId;

public record SeatSelectionRequest(String id) {
    public SeatId toInput(){
        return new SeatId(id);
    }
}
