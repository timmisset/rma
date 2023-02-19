package com.misset.rma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;

@Entity(name = "Booking")
@Table(name = "booking")
public class Booking extends DescribedEntityBase {
    public Booking() {
        super();
    }

    public Booking(String id) {
        super(id);
    }

    private ZonedDateTime fromDateTime;
    private ZonedDateTime toDateTime;
    private String project;
    private String resource;

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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
