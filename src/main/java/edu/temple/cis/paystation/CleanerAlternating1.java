package edu.temple.cis.paystation;

import java.time.DayOfWeek;
import java.time.Duration;

public class CleanerAlternating1 implements RateStrategy{

    paystationCalendar calendar = new paystationCalendar();

    public CleanerAlternating1(){}

    public CleanerAlternating1(String day, int hour, int minute){
        this.calendar = new paystationCalendar(day,hour,minute);
    }

    @Override
    public int calculateTime(int insertedSoFar){
        if (calendar.current.equals(DayOfWeek.SATURDAY) || calendar.current.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            int timebought = (insertedSoFar * 2) / 5;
            calendar.current = calendar.current.plusMinutes(timebought);
            if (!calendar.current.getDayOfWeek().equals(DayOfWeek.SATURDAY) || !calendar.current.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                Duration duration = Duration.between(calendar.weekday, calendar.current);
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
}
