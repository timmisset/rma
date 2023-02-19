package com.misset.rma.model.availability;

import com.misset.rma.model.EntityBase;
import jakarta.persistence.Entity;

import java.time.ZonedDateTime;

@Entity(name = "Pattern")
public abstract class Pattern extends EntityBase {

    private ZonedDateTime from;
    private ZonedDateTime to;
    private Integer interval;

    public ZonedDateTime getFrom() {
        return from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

}
