package com.vehicle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventReportGenerator {

    public static void main(String[] args) throws IOException {

        AccidentDetector detector = new AccidentDetector();

        double[][] scenarios = {
            {2.0, 1.0},
            {5.5, 2.0},
            {9.0, 8.0},
            {2.0, 5.0},
            {7.0, 6.0}
        };

        List<String> report = new ArrayList<>();

        report.add("VEHICLE ACCIDENT DETECTION REPORT");
        report.add("=================================");
        report.add("Generated at: " + LocalDateTime.now());
        report.add("");

        int normal = 0;
        int suddenImpact = 0;
        int possibleAccident = 0;

        for (int i = 0; i < scenarios.length; i++) {

            double acceleration = scenarios[i][0];
            double impact = scenarios[i][1];

            String event = detector.classifyEvent(
                acceleration, impact
            );

            report.add(
                "Scenario " + (i + 1)
                + " | Acceleration: " + acceleration
                + " | Impact: " + impact
                + " | Event: " + event
            );

            switch (event) {
                case "NORMAL":
                    normal++;
                    break;

                case "SUDDEN IMPACT":
                    suddenImpact++;
                    break;

                case "POSSIBLE ACCIDENT":
                    possibleAccident++;
                    break;
            }
        }

        report.add("");
        report.add("EVENT SUMMARY");
        report.add("=============");
        report.add("Normal Events: " + normal);
        report.add("Sudden Impact Events: " + suddenImpact);
        report.add("Possible Accidents: " + possibleAccident);
        report.add("Total Scenarios: " + scenarios.length);

        Path reportPath = Path.of("event-analysis-report.txt");

        Files.write(reportPath, report);

        System.out.println(
            String.join(System.lineSeparator(), report)
        );

        System.out.println(
            "\nReport saved to: " + reportPath.toAbsolutePath()
        );
    }
}