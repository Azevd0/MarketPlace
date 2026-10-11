package com.dio.az.marketplace.catalog.domain.event_domain;

import java.util.UUID;

public record EventId(UUID id) {
    public EventId(){
        this(UUID.randomUUID());
    }

}
