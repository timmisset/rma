package com.misset.rma.model.availability;

import com.misset.rma.model.EntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "Availability")
@Table(name = "availability")
public class Availability extends EntityBase {

    private Collection<Pattern> schema = new ArrayList<>();
    private Collection<Pattern> overrides = new ArrayList<>();

    @OneToMany
    public Collection<Pattern> getSchema() {
        return Collections.unmodifiableCollection(schema);
    }

    public void setSchema(Collection<Pattern> schema) {
        if (schema != null) {
            this.schema.clear();
            this.schema.addAll(schema);
        }
    }

    @OneToMany
    public Collection<Pattern> getOverrides() {
        return Collections.unmodifiableCollection(overrides);
    }

    public void setOverrides(Collection<Pattern> overrides) {
        if (overrides != null) {
            this.overrides.clear();
            this.overrides.addAll(overrides);
        }
    }

}
