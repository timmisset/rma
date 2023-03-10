package com.misset.rma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity(name = "Project")
@Table(name = "project")
public class Project extends EntityBase {

    public Project() {
        super();
    }

    public Project(String id) {
        super(id);
    }

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
