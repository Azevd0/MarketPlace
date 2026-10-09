package com.dio.az.marketplace.registration.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CustomerId (UUID uuid){

    public CustomerId{
        Assert.notNull(uuid, "Id must be not null");
    }
    public CustomerId(){
        this(UUID.randomUUID());
    }
}
