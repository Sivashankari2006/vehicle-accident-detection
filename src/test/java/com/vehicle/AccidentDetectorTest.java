package com.vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AccidentDetectorTest {

    private final AccidentDetector detector =
            new AccidentDetector();

    @Test
    void testNormalDriving() {
        assertEquals(
            "NORMAL",
            detector.classifyEvent(2.0, 1.0)
        );
    }

    @Test
    void testSuddenImpact() {
        assertEquals(
            "SUDDEN IMPACT",
            detector.classifyEvent(5.5, 2.0)
        );
    }

    @Test
    void testPossibleAccident() {
        assertEquals(
            "POSSIBLE ACCIDENT",
            detector.classifyEvent(9.0, 8.0)
        );
    }

    @Test
    void testHighImpact() {
        assertEquals(
            "SUDDEN IMPACT",
            detector.classifyEvent(2.0, 5.0)
        );
    }

    @Test
    void testNegativeSensorReading() {
        assertThrows(
            IllegalArgumentException.class,
            () -> detector.classifyEvent(-1.0, 2.0)
        );
    }
}