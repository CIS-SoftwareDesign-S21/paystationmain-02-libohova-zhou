package edu.temple.cis.paystation;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class paystationCalendar {

    public LocalDateTime current = LocalDateTime.now();
    public LocalDateTime weekend = current.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(0).withMinute(0);
    public LocalDateTime weekday = current.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(0).withMinute(0);

    public paystationCalendar() {

    }

    public paystationCalendar(String day, int hour, int minute) {
        this.current = LocalDateTime.now().with(DayOfWeek.valueOf(day)).withHour(hour).withMinute(minute);
        weekend = current.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).withHour(0).withMinute(0);
        weekday = current.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(0).withMinute(0);
    }
}