package com.andrewrobinson.resth2jpademo.model;

import static com.andrewrobinson.resth2jpademo.model.Seconds.SECONDS_IN_A_MINUTE;
import static com.andrewrobinson.resth2jpademo.model.Seconds.SECONDS_IN_A_MONTH;

class Seconds {
    static int SECONDS_IN_A_MINUTE = 60;
    static int SECONDS_IN_A_MONTH = 30 * 24 * 60 * SECONDS_IN_A_MINUTE;
}
public enum SubscriptionType {

    //https://howtodoinjava.com/java/enum/enum-with-multiple-values/
    DEMO(10,1000,1 * SECONDS_IN_A_MONTH),
    SILVER(1,1,1 * SECONDS_IN_A_MINUTE),
    GOLD(-1,1,10);

    private final int maxStocksPerMonth;
    private final int maxCalls;
    private final int maxCallsPeriodInSeconds;

    SubscriptionType(int maxStocksPerMonth, int maxCalls, int maxCallsPeriodInSeconds) {
        this.maxStocksPerMonth = maxStocksPerMonth;
        this.maxCalls = maxCalls;
        this.maxCallsPeriodInSeconds = maxCallsPeriodInSeconds;
    }

    public int getMaxStocksPerMonth() {
        return maxStocksPerMonth;
    }

    public int getMaxCalls() {
        return maxCalls;
    }

    public int getMaxCallsPeriodInSeconds() {
        return maxCallsPeriodInSeconds;
    }

}