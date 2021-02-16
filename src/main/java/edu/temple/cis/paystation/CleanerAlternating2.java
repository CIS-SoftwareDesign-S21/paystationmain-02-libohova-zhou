package edu.temple.cis.paystation;

import java.time.DayOfWeek;

public class CleanerAlternating2 implements RateStrategy{

    paystationCalendar calendar = new paystationCalendar();

    public CleanerAlternating2(){}

    public CleanerAlternating2(String day, int hour, int minute){
        this.calendar = new paystationCalendar(day,hour,minute);
    }

    @Override
    public int calculateTime(int insertedSoFar) {
        if (calendar.current.equals(DayOfWeek.SATURDAY) || calendar.current.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            System.out.println("Weekends are free.");
            return 0;
        }
        else{
            return (insertedSoFar*2)/5;
        }
    }
}
