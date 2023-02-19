package com.misset.rma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@MappedSuperclass
public class EntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private final String id;

    public EntityBase() {
        id = generateId();
    }

    public EntityBase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private String generateId() {
        UUID randomUUID = UUID.randomUUID();
        String dateStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        return dateStamp + "_" + randomUUID;
    }
}
