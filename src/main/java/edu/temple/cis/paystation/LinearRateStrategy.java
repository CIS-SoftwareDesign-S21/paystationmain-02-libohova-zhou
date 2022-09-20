package edu.temple.cis.paystation;

/**
 *  Linear Rate Strategy
 *  Time = (amount * 2) / 5
 */


public class LinearRateStrategy implements RateStrategy {
    public int calculateTime(int interestedSoFar){
        return interestedSoFar / 5 * 2;
    }

    @Override
    public String toString() {
        return "Linear Rate";
    }
}
