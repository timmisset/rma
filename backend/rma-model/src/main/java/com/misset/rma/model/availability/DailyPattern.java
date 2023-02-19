package com.misset.rma.model.availability;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "DailyPattern")
@Table(name = "dailypattern")
public class DailyPattern extends Pattern {

    private boolean weekDays;
    private boolean weekendDays;

    public boolean isWeekDays() {
        return weekDays;
    }

    public void setWeekDays(boolean weekDays) {
        this.weekDays = weekDays;
    }

    public boolean isWeekendDays() {
        return weekendDays;
    }

    public void setWeekendDays(boolean weekendDays) {
        this.weekendDays = weekendDays;
    }

}
