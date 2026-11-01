package com.dio.az.marketplace.ticketing.domain.sector_domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class Sector {
    private UUID id;
    private SectorId correlationId;
    private BigDecimal price;

    public Sector(String correlationId, BigDecimal price){
        this.id = UUID.randomUUID();
        this.correlationId = new SectorId(correlationId);
        this.price = price;
    }
}
