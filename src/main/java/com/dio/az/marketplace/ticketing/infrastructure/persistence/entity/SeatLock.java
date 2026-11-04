package com.dio.az.marketplace.ticketing.infrastructure.persistence.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Instant;

@RedisHash(value = "seat_locks", timeToLive = 30)
@Data
public class SeatLock {
    @Id
    private String id;

    @Indexed
    private String customerId;
    private Instant createdAt;

    public SeatLock(String id, String customerId, Instant createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.createdAt = createdAt;
    }
}
