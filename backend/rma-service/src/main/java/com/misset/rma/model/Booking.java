package com.misset.rma.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity(name = "Booking")
@Table(name = "booking")
public class Booking extends EntityBase {
    public Booking() {
        super();
    }

    public Booking(String id) {
        super(id);
    }

    private ZonedDateTime fromDateTime;
    private ZonedDateTime toDateTime;
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Project project;
    @JoinColumn(name = "resourceId", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Resource resource;

    public ZonedDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(ZonedDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public ZonedDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(ZonedDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
