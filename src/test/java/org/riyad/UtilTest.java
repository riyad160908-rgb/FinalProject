package org.riyad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    @DisplayName("toTitleCase: null -> null")
    void toTitleCase1() {
        String expected = null;
        String actual = Util.toTitleCase(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: empty -> empty")
    void toTitleCase2() {
        String expected = "";
        String actual = Util.toTitleCase("");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: lower case -> title case")
    void toTitleCase3() {
        String expected = "Computer Science";
        String actual = Util.toTitleCase("computer science");

        Assertions.assertEquals(expected, actual);
    }
}