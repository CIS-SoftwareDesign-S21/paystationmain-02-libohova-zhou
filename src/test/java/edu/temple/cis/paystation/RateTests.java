package edu.temple.cis.paystation;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RateTests {

//    @Test
//    public void getDate(){
//        System.out.println(temp.getDate());
//        assertEquals(5,5);
//    }

    @Test
    public void testRollover(){
        Alternating2 temp = new Alternating2("SUNDAY",23,50);
        int rateTest = temp.calculateTime(375);
        System.out.println(rateTest);
        assertEquals(rateTest,130);
    }
//    @Test
//    public void testNoRollover(){
//        assertEquals(temp.calculateTime(375),150);
//    }
}
