package edu.temple.cis.paystation;

public class Linear2RateStrategy implements RateStrategy{
    @Override
    public int calculateTime(int insertedSoFar) {
        return insertedSoFar/5;
    }

    @Override
    public String toString() {
        return "Linear2";
    }
}
