package org.riyad;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

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
        this.courseName = Util.toTitleCase(courseName);
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

    public void generateScores() {
        Random random = new Random();

        for(Assignment assignment : assignments) {

            for(int i = 0; i < registeredStudents.size(); i++) {
                int randomScore = random.nextInt(assignment.getMaxScore() + 1);
                assignment.getScores().set(i, randomScore);
            }
        }
        calcStudentsAverage();
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");

        System.out.printf("%20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%15s", assignment.getAssignmentName());
        }
        System.out.printf("%15s%n", "Final Score");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%20s", student.getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    System.out.printf("%15d", score);
                } else {
                    System.out.printf("%15s", "Invalid");
                }
            }
            System.out.printf("%15d%n", finalScores[i]);
        }

        System.out.printf("%20s", "Average");
        for (Assignment assignment : assignments) {
            int sum = 0;
            int count = 0;

            for (Integer s : assignment.getScores()) {
                if (s != null) {
                    sum += s;
                    count++;
                }
            }

            double avg = (count == 0) ? 0 : (double) sum / count;
            System.out.printf("%15.0f", avg);
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return courseId + " " + courseName + " " + credits + " " + department.getDepartmentName();
    }

    public String toString() {
        String assignmentList = "";
        if (assignments.isEmpty()) {
            assignmentList = "No assignments";
        } else {
            for (int i = 0; i < assignments.size(); i++) {
                assignmentList += assignments.get(i).toString();
                if (i < assignments.size() - 1) {
                    assignmentList += ", ";
                }
            }
        }

        String studentList = "";
        if (registeredStudents.isEmpty()) {
            studentList = "No students registered";
        } else {
            for (int i = 0; i < registeredStudents.size(); i++) {
                studentList += registeredStudents.get(i).toSimplifiedString();
                if (i < registeredStudents.size() - 1) {
                    studentList += ", ";
                }
            }
        }
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department='" + department.getDepartmentName() + '\'' +
                ", assignments=[" + assignmentList + "]" +
                ", registeredStudents=[" + studentList + "]" +
                ", assignmentWeightsValid=" + (isAssignmentWeightValid() ? "Yes" : "No") +
                '}';
    }
}


