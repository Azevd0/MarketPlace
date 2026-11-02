package com.dio.az.marketplace.ticketing.domain.seat_domain;

import org.springframework.util.Assert;

public record SeatId(String id) {
    public SeatId{
        Assert.notNull(id, "id must be not null!");
    }
}
