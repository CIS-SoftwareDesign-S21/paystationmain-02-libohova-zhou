package edu.temple.cis.paystation;

import org.junit.Test;

import javax.sound.sampled.Line;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.util.*;

import java.time.LocalDateTime;

//import static org.junit.jupiter.api.Assertions.*;

public class RateTests {

//    @Test
//    public void getDate(){
//        System.out.println(temp.getDate());
//        assertEquals(5,5);
//    }

    @Test
    public void testWeekdayRolloverAlternating1(){
        CleanerAlternating1 temp = new CleanerAlternating1("SUNDAY",23,50);
        int rateTest = temp.calculateTime(375);
        assertEquals(rateTest,130);
    }
    @Test
    public void testNoRolloverAlternating1(){
        CleanerAlternating1 temp = new CleanerAlternating1("MONDAY",0,0);
        assertEquals(temp.calculateTime(375),150);
    }
    @Test
    public void testWeekendAlternating2(){
        CleanerAlternating2 temp = new CleanerAlternating2("SUNDAY",0,0);
        assertEquals(temp.calculateTime(200),0);
    }
    @Test
    public void testLinear2(){
        Linear2RateStrategy temp = new Linear2RateStrategy();
        assertEquals(temp.calculateTime(120),24);
    }
    @Test
    public void testLinear(){
        LinearRateStrategy temp = new LinearRateStrategy();
        assertEquals(temp.calculateTime(120),48);
    }

    @Test
    public void testCalendar(){
        paystationCalendar temp = new paystationCalendar("SUNDAY",12,12);
        assertTrue(temp.weekday.getDayOfWeek().equals(DayOfWeek.MONDAY));
    }

}
