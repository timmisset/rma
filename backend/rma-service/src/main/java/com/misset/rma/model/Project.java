package com.misset.rma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Project extends EntityBase {

    @OneToMany
    private final Collection<Resource> resourceCollection = new ArrayList<>();

    public void addResource(Resource resource) {
        resourceCollection.add(resource);
    }

    public void addAllResources(Collection<Resource> resources) {
        resourceCollection.addAll(resources);
    }

    public Collection<Resource> getResources() {
        return Collections.unmodifiableCollection(resourceCollection);
    }

    public void setResources(Collection<Resource> resources) {
        resourceCollection.clear();
        resourceCollection.addAll(resources);
    }

}
