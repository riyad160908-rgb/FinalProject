package org.riyad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    @DisplayName("isDepartmentNameValid: null -> false")
    void isDepartmentNameValid1() {
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(null);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: \"\" -> false")
    void isDepartmentNameValid2() {
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid("");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Computer Science -> true")
    void isDepartmentNameValid3() {
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid("Computer Science");
        assertEquals(expected, actual);
    }
}