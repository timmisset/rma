package com.misset.rma.model.availability;

import com.misset.rma.model.EntityBase;
import jakarta.persistence.Entity;
import org.apache.commons.lang3.Range;

import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;

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

    public Range<ZonedDateTime> computeRange() {
        ZonedDateTime now = ZonedDateTime.now();
        return Range.between(
                from == null ? now : from,
                to == null ? now : to,
                ChronoZonedDateTime::compareTo);
    }
}
