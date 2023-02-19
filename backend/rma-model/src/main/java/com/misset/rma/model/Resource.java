package com.misset.rma.model;

import com.misset.rma.model.availability.Availability;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "Resource")
@Table(name = "resource")
public class Resource extends DescribedEntityBase {
    public Resource() {
        super();
    }

    public Resource(String id) {
        super(id);
    }

    private Availability availability;

    @OneToOne
    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
