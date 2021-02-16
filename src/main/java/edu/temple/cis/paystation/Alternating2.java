package edu.temple.cis.paystation;

import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.time.*;

public class Alternating2 implements RateStrategy{

    LocalDateTime calendar;
    private String day = "MONDAY";
    private int hour = 0;
    private int minute = 0;
    private int offset;
    private int timeleft;
    LocalDateTime weekdayRollover = LocalDateTime.now().with(DayOfWeek.MONDAY).withHour(0).withMinute(0);
    LocalDateTime weekendRollover = LocalDateTime.now().with(DayOfWeek.SATURDAY).withHour(0).withMinute(0);

    public Alternating2(){

    }

    public Alternating2(String day, int hour, int minute){
        this.calendar = LocalDateTime.now().with(DayOfWeek.valueOf(day)).withHour(hour).withMinute(minute);
        this.day=day;
        this.hour=hour;
        this.minute=minute;
//        weekdayRollover = calendar.with(DayOfWeek.MONDAY).withHour(0).withMinute(0);
//        System.out.println("Current Day Constructor: " + calendar);
        weekdayRollover = calendar.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(0).withMinute(0);
    }

    public LocalDateTime getDate(){
        return this.calendar;
    }

    //Placeholder to not have errors
    @Override
    public int calculateTime(int insertedSoFar){
        if (calendar.getDayOfWeek().equals(DayOfWeek.SATURDAY) || calendar.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            int timebought = (insertedSoFar * 2) / 5;
//            System.out.println("timebought: " + timebought);
//            weekdayRollover = calendar.with(DayOfWeek.MONDAY).withHour(0).withMinute(0);;
//            System.out.println("Current Day Before: " + calendar);
            calendar = calendar.plusMinutes(timebought);
//            System.out.println("Current Day After: " + calendar);
//            System.out.println("Next Monday: " + weekdayRollover);
            if (!calendar.getDayOfWeek().equals(DayOfWeek.SATURDAY) || !calendar.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                Duration duration = Duration.between(weekdayRollover, calendar);
                timebought -= duration.getSeconds()/60;
//                System.out.println("Minutes past weekend: " + duration.getSeconds()/60);
                int insertedLeft = Math.round(duration.getSeconds() / 24);
//                System.out.println("Inserted Left: " + insertedLeft);
                ProgressiveRateStrategy temp = new ProgressiveRateStrategy();
                int timeLeft = temp.calculateTime(insertedLeft);
//                System.out.println("Time Left: " + timeLeft);
                timebought += timeLeft;
            }
            return timebought;
        }
        else{
            return (insertedSoFar*2)/5;
        }
    }

    @Override
    public String toString() {
        return "Alternating2 Rate";
    }

}
