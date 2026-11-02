package com.dio.az.marketplace.ticketing.domain.sector_domain;

import org.springframework.util.Assert;

public record SectorId(String id) {
    public SectorId {
        Assert.notNull(id, "id must be not null!");
    }
}
