package com.docencia.fechas.ejercicio4;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio4Test {

    @Test
    void endOfMonthShouldReturnLastDayForFebruaryNonLeap() {
        assertEquals(LocalDate.of(2026, 2, 28), Ejercicio4.endOfMonth(LocalDate.of(2026, 2, 10)));
    }

    @Test
    void endOfMonthShouldReturnLastDayForJanuary() {
        assertEquals(LocalDate.of(2026, 1, 31), Ejercicio4.endOfMonth(LocalDate.of(2026, 1, 5)));
    }

    @Test
    void endOfMonthShouldThrowOnNull() {
        assertThrows(NullPointerException.class, () -> Ejercicio4.endOfMonth(null));
    }

    @Test
    void endOfMonthShouldHandleLeapYear() {
        assertEquals(LocalDate.of(2024, 2, 29), Ejercicio4.endOfMonth(LocalDate.of(2024, 2, 1)));
    }

    @Test
    void endOfMonthShouldKeepSameMonth() {
        assertEquals(Month.MARCH, Ejercicio4.endOfMonth(LocalDate.of(2026, 3, 1)).getMonth());
    }
}
