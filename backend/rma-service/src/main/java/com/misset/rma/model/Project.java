package com.misset.rma.model;

import com.misset.rma.utils.RmaGUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Project {

    @Id
    @Column(name = "id", nullable = false)
    @Getter
    private final String id;
    @OneToMany
    private final Collection<Resource> resourceCollection = new ArrayList<>();
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;

    public Project() {
        id = RmaGUID.generateGUID();
    }

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
