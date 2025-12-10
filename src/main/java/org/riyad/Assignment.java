package org.riyad;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;


@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores = new ArrayList<>();

    private static int nextId = 1;


    public void calcAssignmetnAvg() {
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
