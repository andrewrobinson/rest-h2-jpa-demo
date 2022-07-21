package com.andrewrobinson.resth2jpademo.model;

public class PredictionRequest {

    private String stockSymbol;
    private int durationInDays;

    public PredictionRequest(String stockSymbol, int durationInDays) {
        this.stockSymbol = stockSymbol;
        this.durationInDays = durationInDays;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

}
