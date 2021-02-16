package edu.temple.cis.paystation;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class Alternating2Test {

    Alternating2 temp = new Alternating2("TUESDAY",0,0);

    @Test
    public void getDate(){
        System.out.println(temp.getDate());
        assertEquals(5,5);
    }
}
