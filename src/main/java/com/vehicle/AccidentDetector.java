package com.vehicle;

public class AccidentDetector {

    public String classifyEvent(double acceleration, double impact) {

        if (acceleration < 0 || impact < 0) {
            throw new IllegalArgumentException(
                "Sensor readings cannot be negative."
            );
        }

        if (acceleration >= 8.0 && impact >= 7.0) {
            return "POSSIBLE ACCIDENT";
        }

        if (acceleration >= 5.0 || impact >= 4.0) {
            return "SUDDEN IMPACT";
        }

        return "NORMAL";
    }
}