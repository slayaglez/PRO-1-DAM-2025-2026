package com.docencia.fechas.ejercicio7;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio7Test {

    @Test
    void isOpenInclusiveShouldBeTrueInsideWindow() {
        assertTrue(Ejercicio7.isOpenInclusive(LocalTime.of(10, 0), LocalTime.of(9, 0), LocalTime.of(18, 0)));
    }

    @Test
    void isOpenInclusiveShouldIncludeCloseBoundary() {
        assertTrue(Ejercicio7.isOpenInclusive(LocalTime.of(18, 0), LocalTime.of(9, 0), LocalTime.of(18, 0)));
    }

    @Test
    void isOpenInclusiveShouldThrowOnNullT() {
        assertThrows(NullPointerException.class, () -> Ejercicio7.isOpenInclusive(null, LocalTime.NOON, LocalTime.MIDNIGHT));
    }

    @Test
    void isOpenInclusiveShouldSupportWrapMidnight() {
        assertTrue(Ejercicio7.isOpenInclusive(LocalTime.of(1, 0), LocalTime.of(22, 0), LocalTime.of(6, 0)));
    }

    @Test
    void isOpenInclusiveShouldBeFalseOutsideWindow() {
        assertFalse(Ejercicio7.isOpenInclusive(LocalTime.of(8, 59), LocalTime.of(9, 0), LocalTime.of(18, 0)));
    }
}
