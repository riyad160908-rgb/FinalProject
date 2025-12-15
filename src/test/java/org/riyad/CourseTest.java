package org.riyad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    @DisplayName("isAssignmentWeightValid: no assignments -> false")
    void isAssignmentWeightValid1() {
        Course course = new Course("Programming", 3.0, null);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid: weight: 30 + 40 -> false")
    void isAssignmentWeightValid2() {
        Course course = new Course("Programming", 3.0, null);
        course.addAssignment("A1", 30, 100);
        course.addAssignment("A2", 40, 100);

        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isAssignmentWeightValid: weight: 30 + 70 -> true")
    void isAssignmentWeightValid3() {
        Course course = new Course("Programming", 3.0, null);
        course.addAssignment("A1", 30, 100);
        course.addAssignment("A2", 70, 100);

        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent: null -> false")
    void registerStudent1() {
        Course course = new Course("Programming", 3.0, null);

        boolean expected = false;
        boolean actual = course.registerStudent(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent: normal student -> true")
    void registerStudent2() {
        Course course = new Course("Programming", 3.0, null);
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);

        boolean expected = true;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerStudent: same student twice -> false")
    void registerStudent3() {
        Course course = new Course("Programming", 3.0, null);
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);

        course.registerStudent(student);

        boolean expected = false;
        boolean actual = course.registerStudent(student);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage: no students -> []")
    void calcStudentsAverage1() {
        Course course = new Course("Programming", 3.0, null);

        int[] expected = {};
        int[] actual = course.calcStudentsAverage();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage: 1 student, no assignments-> [0]")
    void calcStudentsAverage2() {
        Course course = new Course("Programming", 3.0, null);

        Student s1 = new Student("Riyad", Student.Gender.MALE, null, null);
        course.registerStudent(s1);

        int[] expected = {0};
        int[] actual = course.calcStudentsAverage();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("calcStudentAverage: two students with scores 90 and 60 -> [90,60]")
    void calcStudentsAverage3() {
        Course course = new Course("Programming", 3.0, null);

        course.addAssignment("A1", 50, 100);
        course.addAssignment("A2", 50, 100);

        Student s1 = new Student("A", Student.Gender.MALE, null, null);
        Student s2 = new Student("B", Student.Gender.MALE, null, null);

        course.registerStudent(s1);
        course.registerStudent(s2);

        course.getAssignments().get(0).getScores().add(80);
        course.getAssignments().get(0).getScores().add(50);

        course.getAssignments().get(1).getScores().add(100);
        course.getAssignments().get(1).getScores().add(70);

        int[] expected = {90, 60};
        int[] actual = course.calcStudentsAverage();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment: normal assignment -> true")
    void addAssignment1() {
        Course course = new Course("Programming", 3.0, null);

        boolean expected = true;
        boolean actual = course.addAssignment("A1", 20, 100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment: total weight exceeds 100 -> false")
    void addAssignment2() {
        Course course = new Course("Programming", 3.0, null);
        course.addAssignment("A1", 80, 100);

        boolean expected = false;
        boolean actual = course.addAssignment("A2", 30, 100);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addAssignment: total weight is 100 -> true")
    void addAssignment3() {
        Course course = new Course("Programming", 3.0, null);
        course.addAssignment("A1", 60, 100);

        boolean expected = true;
        boolean actual = course.addAssignment("A2", 40, 100);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateScore:  no students / no assignments -> works")
    void generateScores1() {
        Course course = new Course("Programming", 3.0, null);

        boolean expected = true;
        course.generateScores();
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateScore:  1 student, 1 assignment -> works")
    void generateScores2() {
        Course c = new Course("Programming", 3.0, null);
        c.addAssignment("A1", 100, 100);

        Student s = new Student("Riyad", Student.Gender.MALE, null, null);
        c.registerStudent(s);

        boolean expected = true;
        c.generateScores();
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateScore:  2 students, 2 assignments -> works")
    void generateScores3() {
        Course c = new Course("Programming", 3.0, null);
        c.addAssignment("A1", 50, 100);
        c.addAssignment("A2", 50, 100);

        c.registerStudent(new Student("A", Student.Gender.MALE, null, null));
        c.registerStudent(new Student("B", Student.Gender.MALE, null, null));

        boolean expected = true;
        c.generateScores();
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("displayScores: empty assignment-> works")
    void displayScores1() {
        Course c = new Course("Programming", 3.0, null);

        boolean expected = true;
        c.displayScores();
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("displayScores: 1 student, 1 assignment -> works")
    void displayScores2() {
        Course c = new Course("Programming", 3.0, null);
        c.addAssignment("A1", 100, 100);

        Student s = new Student("Riyad", Student.Gender.MALE, null, null);
        c.registerStudent(s);

        c.generateScores();

        boolean expected = true;
        c.displayScores();
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("displayScores: 2 students, 2 assignments -> works")
    void displayScores3() {
        Course c = new Course("Programming", 3.0, null);
        c.addAssignment("A1", 50, 100);
        c.addAssignment("A2", 50, 100);

        c.registerStudent(new Student("A", Student.Gender.MALE, null, null));
        c.registerStudent(new Student("B", Student.Gender.MALE, null, null));

        c.generateScores();

        boolean expected = true;
        c.displayScores();
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString:  null -> C-D00-01 | Programming | 3.0 | null")
    void toSimplifiedString1() {
        Course c = new Course("Programming", 3.0, null);

        String expected = "C-D00-01 | Programming | 3.0 | null";
        String actual = c.toSimplifiedString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString:  empty -> C-D00-01 | Programming | 3.0 | ")
    void toSimplifiedString2() {
        Department dep = new Department("");
        Course c = new Course("Programming", 3.0, dep);

        String expected = "C-D00-01 | Programming | 3.0 | ";
        String actual = c.toSimplifiedString();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    @DisplayName("toSimplifiedString:  normal -> C-D00-01 | Programming | 3.0 | Science")
    void toSimplifiedString3() {
        Department dep = new Department("Science");
        Course c = new Course("Programming", 3.0, dep);

        String expected = "C-D00-01 | Programming | 3.0 | Science";
        String actual = c.toSimplifiedString();

        Assertions.assertEquals(expected, actual);
    }
}
