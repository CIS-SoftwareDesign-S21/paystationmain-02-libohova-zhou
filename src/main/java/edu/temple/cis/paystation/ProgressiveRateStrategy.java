package edu.temple.cis.paystation;

/**
 * Progressive Rate Strategy
 * Less than an hour so amount <150
 * time = (aount*2) /5
 * between 1st hour and 2nd hour 350> amount >= 150
 * time = (amount -150) * (3/10) +60;
 * greater than 2 hours so amount >= 350
 * time = (amount - 350) / 5 + 120;
 */

public class ProgressiveRateStrategy implements RateStrategy{
    public int calculateTime (int insertedSoFar){
        int time = 0;
        // to make it easier start with the highest so greater than 2 hours if ....
        if (insertedSoFar >= 350){
            insertedSoFar -= 350;
            time = (insertedSoFar / 5) + 120;
        } else if (insertedSoFar >= 150){
            insertedSoFar -= 150;
            time = insertedSoFar * (3/10) + 60;
            // so if it isnt equal to 150 or greater else we know the time will be insertedSoFar / 5 * 2
        } else {
            time = insertedSoFar / 5 * 2;

        }
        return time;
    }

    @Override
    public String toString() {
        return "Progressive Rate";
    }
}