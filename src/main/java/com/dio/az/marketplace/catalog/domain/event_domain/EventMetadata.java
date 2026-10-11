package com.dio.az.marketplace.catalog.domain.event_domain;


import com.dio.az.marketplace.catalog.domain.seat_domain.Seat;
import com.dio.az.marketplace.catalog.domain.sector_domain.Sector;

import java.util.List;
import java.util.Map;

public record EventMetadata(String eventDescription,
                            Map<String, Object> technicalRequirements,
                            Map<Sector, List<Seat>> seats) {
}
