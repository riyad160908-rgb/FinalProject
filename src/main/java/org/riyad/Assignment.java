package org.riyad;

import lombok.Getter;

import java.util.ArrayList;


@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores = new ArrayList<>();

    private static int nextId = 1;


    public void calcAssignmetnAvg() {
        if (scores.isEmpty()) {
            System.out.println("No scores for " + assignmentName);
            return;
        }

        int sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No valid scores for " + assignmentName);
            return;
        }

        double avg =  (double) sum / count;
        System.out.println("Average for " + assignmentName + " is " + avg);
    }
}
