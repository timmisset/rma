package com.misset.rma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "Resource")
@Table(name = "resource")
public class Resource extends EntityBase {
    public Resource() {
        super();
    }

    public Resource(String id) {
        super(id);
    }
}
