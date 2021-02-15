package edu.temple.cis.paystation;


import jdk.vm.ci.meta.Local;

import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.time.*;

public class Alternating2 implements RateStrategy{

    LocalDateTime calendar;
    private String day = "MONDAY";
    private int hour = 0;
    private int minute = 0;
    LocalDateTime weekdayRollover = LocalDateTime.now().with(DayOfWeek.MONDAY).withHour(0).withMinute(0);
    LocalDateTime weekendRollover = LocalDateTime.now().with(DayOfWeek.SATURDAY).withHour(0).withMinute(0);

    public Alternating2(String day, int hour, int minute){
        this.calendar = LocalDateTime.now().with(DayOfWeek.valueOf(day)).withHour(hour).withMinute(minute);
        this.day=day;
        this.hour=hour;
        this.minute=minute;
    }

    //Placeholder to not have errors
    @Override
    public int calculateTime(int insertedSoFar){
        return (insertedSoFar * 2) /5;
    }

    @Override
    public String toString() {
        return "Alternating2 Rate";
    }

}
