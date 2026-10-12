package com.dio.az.marketplace.catalog.domain.sector_domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Sector {
    private SectorId id;
    private BigDecimal price;

    public Sector(SectorId id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }
}
