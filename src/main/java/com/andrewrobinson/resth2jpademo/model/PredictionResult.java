package com.andrewrobinson.resth2jpademo.model;

import java.util.ArrayList;
import java.util.List;

public class PredictionResult {

    private PredictionRequest predictionRequest;
    private List<Integer> predictions;

    PredictionResult(PredictionRequest predictionRequest, int currentValue) {
        predictions = new ArrayList<>();
        predictions.add(currentValue);
        for (int i = 0; i < predictionRequest.getDurationInDays(); i++) {
            predictions.add(currentValue + getRandomNumber(-100, 100));
        }
    }

    private int getRandomNumber(int min, int max) {
        int randomWithMathRandom = (int) ((Math.random() * (max - min)) + min);
        return randomWithMathRandom;
    }

    public PredictionRequest getPredictionRequest() {
        return predictionRequest;
    }

    public void setPredictionRequest(PredictionRequest predictionRequest) {
        this.predictionRequest = predictionRequest;
    }

    public List<Integer> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Integer> predictions) {
        this.predictions = predictions;
    }

}
