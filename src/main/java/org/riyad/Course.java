package org.riyad;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId() ,nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return sum == 100;
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        return true;
    }

    public int[] calcStudentsAverage() {
        int[] result = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    total += score * (assignment.getWeight() / 100.0);
                }
            }
            result[i] = (int) Math.round(total);
        }
        return result;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if(assignmentName == null || assignmentName.isBlank() || weight <= 0 || maxScore <= 0) {
            return false;
        }

        Assignment newAssignment = new Assignment(assignmentName, weight, maxScore);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        assignments.add(newAssignment);
        return true;
    }

}
