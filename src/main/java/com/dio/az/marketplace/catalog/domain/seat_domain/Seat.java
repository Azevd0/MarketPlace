package com.dio.az.marketplace.catalog.domain.seat_domain;

import com.dio.az.marketplace.catalog.domain.sector_domain.SectorId;
import lombok.Data;

@Data
public class Seat {
    private Seatid id;
    private SectorId sectorId;

    public Seat(Seatid id, SectorId sectorId) {
        this.id = id;
        this.sectorId = sectorId;
    }
}
