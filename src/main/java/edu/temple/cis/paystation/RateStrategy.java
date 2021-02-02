package edu.temple.cis.paystation;

/**
 * Calculating time based on # of coins
 */
public interface RateStrategy {
    public int calculateTime(int interestedSoFar);

}
