package com.misset.rma.model.availability;

import com.misset.rma.model.EntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Collection;

@Entity(name = "Availability")
@Table(name = "availability")
public class Availability extends EntityBase {

    private Collection<Pattern> schema;
    private Collection<Pattern> overrides;

    @OneToMany
    public Collection<Pattern> getSchema() {
        return schema;
    }

    public void setSchema(Collection<Pattern> schema) {
        this.schema = schema;
    }

    @OneToMany
    public Collection<Pattern> getOverrides() {
        return overrides;
    }

    public void setOverrides(Collection<Pattern> overrides) {
        this.overrides = overrides;
    }

}
