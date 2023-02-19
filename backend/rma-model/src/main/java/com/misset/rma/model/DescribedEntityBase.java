package com.misset.rma.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class DescribedEntityBase extends EntityBase {
    private String name;
    private String description;

    public DescribedEntityBase() {
    }

    public DescribedEntityBase(String id) {
        super(id);
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
