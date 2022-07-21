package com.andrewrobinson.resth2jpademo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredictionRequestTest {

    @Test
    public void test() {

        var predictions = new PredictionResult(
                new PredictionRequest("ABC", 5),
                300)
                .getPredictions();

        System.out.println(String.join(",", predictions + ""));

        assertTrue(predictions.size() == 6);

        for (int val : predictions) {
            assertTrue(val >= 200);
            assertTrue(val <= 400);
        }

    }
}
