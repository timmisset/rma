package com.misset.rma.model.availability;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "WeeklyPattern")
@Table(name = "weeklypattern")
public class WeeklyPattern extends Pattern {

    private List<DayOfWeek> weekDays = new ArrayList<>();

    @ElementCollection(targetClass = DayOfWeek.class)
    @CollectionTable(name = "weeklypattern", joinColumns = @JoinColumn(name = "weeklypattern_id"))
    @Column(name = "weekdays_id")
    public List<DayOfWeek> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<DayOfWeek> weekDays) {
        this.weekDays.clear();
        this.weekDays.addAll(weekDays);
    }

    public void addWeekDay(DayOfWeek dayOfWeek) {
        this.weekDays.add(dayOfWeek);
    }
}
