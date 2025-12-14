package org.riyad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    @DisplayName("isPostalCodeValid: null -> false")
    void isPostalCodeValid1() {
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: \"\" -> false")
    void isPostalCodeValid2() {
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid("");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: A3B4C8 -> false")
    void isPostalCodeValid3() {
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid("A3B4C8");
        Assertions.assertEquals(expected, actual);
    }
}