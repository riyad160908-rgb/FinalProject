package org.riyad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {

    @Test
    @DisplayName("calcAssignmentAvg: null -> size stay 2")
    void calcAssignmentAvg1() {
        Assignment assignment = new Assignment("Exam", 5, 100);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        int expected = 2;
        assignment.calcAssignmentAvg();
        int actual = assignment.getScores().size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcAssignmentAvg: empty -> size stay 0")
    void calcAssignmentAvg2() {
        Assignment assignment = new Assignment("Exam", 5, 100);

        int expected = 0;
        assignment.calcAssignmentAvg();
        int actual = assignment.getScores().size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcAssignmentAvg: [70,80,90]-> size 3")
    void calcAssignmentAvg3() {
        Assignment assignment = new Assignment("Exam", 5, 100);
        assignment.getScores().add(70);
        assignment.getScores().add(80);
        assignment.getScores().add(90);

        int expected = 3;
        assignment.calcAssignmentAvg();
        int actual = assignment.getScores().size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateRandomScore: empty -> size stay 0")
    void generateRandomScore1() {
        Assignment assignment = new Assignment("Exam", 5, 100);

        int expected = 0;
        assignment.generateRandomScore();
        int actual = assignment.getScores().size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateRandomScore: null -> size stay 2")
    void generateRandomScore2() {
        Assignment assignment = new Assignment("Exam", 5, 100);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        int expected = 2;
        assignment.generateRandomScore();
        int actual = assignment.getScores().size();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateRandomScore: [70,80,90] -> size stay 3")
    void generateRandomScore3() {
        Assignment assignment = new Assignment("Exam", 5, 100);
        assignment.getScores().add(70);
        assignment.getScores().add(80);
        assignment.getScores().add(90);

        int expected = 3;
        assignment.generateRandomScore();
        int actual = assignment.getScores().size();

        assertEquals(expected, actual);
    }
}