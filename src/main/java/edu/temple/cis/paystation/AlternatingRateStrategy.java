package edu.temple.cis.paystation;

public class AlternatingRateStrategy implements RateStrategy {

    private RateStrategy weekdayRateStrategy , weekendRateStrategy, currentRateStrategy;
//    private WeekendRateStrategy;
    public int calculateTime(int insertedSoFar){
        //placeholder
        return 5;
    }

    @Override
    public String toString() {
        return "Alternating Rate";
    }

}
