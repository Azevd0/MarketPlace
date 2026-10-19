package com.dio.az.marketplace.catalog.infrastructure.persistence.entity;

import com.dio.az.marketplace.catalog.infrastructure.event.EventListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@EntityListeners(EventListener.class)
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Instant date;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Instant createdOn;

    public Event(UUID id, String title, Instant date, Instant createdOn) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.createdOn = createdOn;
    }
    public Event(){}
}
