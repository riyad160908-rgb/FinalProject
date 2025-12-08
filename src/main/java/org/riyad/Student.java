package org.riyad;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;

    private static int nextId = 1;

    public Student(String studentName, Gender gender, Department department, Address address) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.department = department;
        this.address = address;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if(course == null || registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);

        course.getRegisteredStudents().add(this);

        for(Assignment a : course.getAssignments()) {
            a.getScores().add(null);
        }
        return true;
    }

    public boolean dropCourse(Course course) {
        if(course == null || !registeredCourses.contains(course)) {
            return false;
        }

        int studentIdx = course.getRegisteredStudents().indexOf(this);
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(studentIdx);

        for(Assignment a : course.getAssignments()) {
            if(studentIdx < a.getScores().size()) {
                a.getScores().remove(studentIdx);
            }
        }
        return true;
    }

    public String toSimplifiedString() {
        return studentId + " " + studentName + " " + department.getDepartmentName();
    }

    public enum Gender {
        MALE,
        FEMALE,
    }
}
