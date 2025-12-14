package org.riyad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("registerCourse: null -> false")
    void registerCourse1() {
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);

        boolean expected = false;
        boolean actual = student.registerCourse(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerCourse: not registered yet -> true")
    void registerCourse2() {
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);
        Course course = new Course("Programming", 2.0, null);

        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("registerCourse: already registered -> false")
    void registerCourse3() {
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);
        Course course = new Course("Programming", 2.0, null);

        student.registerCourse(course);

        boolean expected = false;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse: null -> false")
    void dropCourse1() {
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);

        boolean expected = false;
        boolean actual = student.dropCourse(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse: course not registered -> false")
    void dropCourse2() {
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);
        Course course = new Course("Programming", 2.0, null);

        boolean expected = false;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("dropCourse: course registered -> true")
    void dropCourse3() {
        Student student = new Student("Riyad", Student.Gender.MALE, null, null);
        Course course = new Course("Programming", 2.0, null);

        student.dropCourse(course);

        boolean expected = true;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString: null -> null")
    void toSimplifiedString1() {
        Student s = new Student("Riyad", Student.Gender.MALE, null, null);

        String expected = s.getStudentId() + "S000001 | Riyad | null";
        String actual = s.toSimplifiedString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString: empty -> empty")
    void toSimplifiedString2() {
        Department dep = new Department("");
        Student s = new Student("Riyad", Student.Gender.MALE, dep, null);

        String expected = "S000001 | Riyad | ";
        String actual = s.toSimplifiedString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toSimplifiedString: normal case -> ")
    void toSimplifiedString3() {
        Department dep = new Department("Science");
        Student s = new Student("Riyad", Student.Gender.MALE, dep, null);

        String expected = s.getStudentId() + "S000001 | Riyad | Science";
        String actual = s.toSimplifiedString();
        assertEquals(expected, actual);
    }
}