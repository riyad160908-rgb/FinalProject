package org.riyad;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;


@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private ArrayList<Integer> scores = new ArrayList<>();

    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = String.format("A%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.scores = new ArrayList<>();
    }

    /**
     * calculates and returns the average score for the assignment
     */
    public void calcAssignmentAvg() {
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

    /**
     * generates a random score for all students in the assignment
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {

            int randomNum = random.nextInt(11);
            int score = switch (randomNum) {

                case 0 -> random.nextInt(60);

                case 1, 2 -> 60 + random.nextInt(10);

                case 3, 4 -> 70 + random.nextInt(10);

                case 5, 6, 7, 8 -> 80 + random.nextInt(10);

                case 9, 10 -> 90 + random.nextInt(11);

                default -> 0;
            };
            scores.set(i, score);
        }
    }

    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
