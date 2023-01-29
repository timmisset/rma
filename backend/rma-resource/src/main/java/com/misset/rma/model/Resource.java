package com.misset.rma.model;

import com.misset.rma.utils.RmaGUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Resource {
    @Id
    @Column(name = "id", nullable = false)
    @Getter
    private final String id;

    @Getter
    @Setter
    private String name;

    public Resource() {
        id = RmaGUID.generateGUID();
    }
}
