package edu.temple.cis.paystation;

public class AlternatingRateStrategy implements RateStrategy {
//declarations
    private RateStrategy weekdayRateStrategy;
    private RateStrategy weekendRateStrategy;
    private RateStrategy currentRateStrategy;
    private WeekendStrategyPick pickStrategy;

// constructor
    public AlternatingRateStrategy(RateStrategy weekdayRateStrategy, RateStrategy weekendRateStrategy, WeekendStrategyPick pickstrategy){
        this.weekdayRateStrategy = weekdayRateStrategy;
        this.weekendRateStrategy = weekendRateStrategy;
        this.currentRateStrategy = null;
        this.pickStrategy = pickstrategy;

    }
    // if and else statement for weekend or weekday
    public int calculateTime(int insertedSoFar){
        if(pickStrategy.theWeekend()){
            currentRateStrategy = weekendRateStrategy;
        } else {
            currentRateStrategy = weekdayRateStrategy;
        }
        return currentRateStrategy.calculateTime(insertedSoFar);
    }


}
