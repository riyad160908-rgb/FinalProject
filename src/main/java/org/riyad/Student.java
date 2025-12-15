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
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.department = department;
        this.address = address;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Registers a student to a course:
     * Adds the course to the student's registered list,
     * adds the student to the course's student list,
     * and appends a null score for each assignment.
     * @param course the course that the student will be registered in
     * @return true if registration succeeds, false if already registered
     */
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

    /**
     * Drops a course for a student:
     * removes the course from the registeredCourses list,
     * and removes the student from the course's registeredStudents list
     * @param course the course to drop for the student
     * @return true if successful, false if the course is not in the student's registeredCourses list
     */
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

    /**
     * Returns a simplified string with studentId, studentName, and departmentName.
     * @return simplified student information
     */
    public String toSimplifiedString() {
        return studentId + " " + studentName + " " + department.getDepartmentName();
    }

    public String toString() {
        String courses = "";

        if (registeredCourses.isEmpty()) {
            courses = "No courses registered";
        } else {
            for (int i = 0; i < registeredCourses.size(); i++) {
                Course c = registeredCourses.get(i);

                courses += c.getCourseId() + ", "
                        + c.getCourseName() + ", "
                        + c.getDepartment().getDepartmentName();

                if (i < registeredCourses.size() - 1) {
                    courses += ", ";
                }
            }
        }
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department.getDepartmentName() +
                ", registeredCourses=[" + courses + "]" +
                '}';
    }

    /**
     * enumeration for gender
     */
    public enum Gender {
        MALE,
        FEMALE,
    }
}
