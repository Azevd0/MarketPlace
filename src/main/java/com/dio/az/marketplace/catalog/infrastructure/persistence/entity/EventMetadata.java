package com.dio.az.marketplace.catalog.infrastructure.persistence.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Document
public class EventMetadata {
    @Id
    private String id;

    @NotNull
    private UUID eventId;

    private String eventDescription;
    private Map<String, Object> technicalRequirements;
    private List<Sector> sectors;
    private List<Seat> seats;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public EventMetadata(String id, UUID eventId, String eventDescription, Map<String, Object> technicalRequirements, List<Sector> sectors, List<Seat> seats, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.eventId = eventId;
        this.eventDescription = eventDescription;
        this.technicalRequirements = technicalRequirements;
        this.sectors = sectors;
        this.seats = seats;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public EventMetadata(){}

    @Data
    public static class Sector{
        private String name;
        private BigDecimal price;

        public Sector(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }
        public Sector(){}
    }
    @Data
    public static class Seat{
        private String code;
        private String sectorName;

        public Seat(String code, String sectorName) {
            this.code = code;
            this.sectorName = sectorName;
        }
        public Seat(){}
    }
}
