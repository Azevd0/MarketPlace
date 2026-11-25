package com.dio.az.marketplace.ticketing.domain.event_domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record EventId(UUID id) {
    public EventId{
        Assert.notNull(id, "id must be not null!");
    }
    public EventId(String id){
        this(UUID.fromString(id));
    }
}
