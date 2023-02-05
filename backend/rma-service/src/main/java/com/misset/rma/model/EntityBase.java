package com.misset.rma.model;

import com.misset.rma.utils.RmaGUID;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityBase {

    @Id
    @Column(name = "id", nullable = false)
    private final String id;
    private String name;
    private String description;

    public EntityBase() {
        id = RmaGUID.generateGUID();
    }

    public EntityBase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
