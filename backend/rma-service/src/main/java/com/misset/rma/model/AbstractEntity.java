package com.misset.rma.model;

import com.misset.rma.utils.RmaGUID;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    private final String id;

    private String name;

    private String description;

    public AbstractEntity() {
        id = RmaGUID.generateGUID();
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
