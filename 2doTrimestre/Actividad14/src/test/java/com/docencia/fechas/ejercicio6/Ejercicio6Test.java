package com.docencia.fechas.ejercicio6;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio6Test {

    @Test
    void addBusinessDaysShouldSkipWeekend() {
        assertEquals(LocalDate.of(2026, 2, 9), Ejercicio6.addBusinessDays(LocalDate.of(2026, 2, 6), 1));
    }

    @Test
    void addBusinessDaysShouldReturnSameWhenZero() {
        assertEquals(LocalDate.of(2026, 2, 10), Ejercicio6.addBusinessDays(LocalDate.of(2026, 2, 10), 0));
    }

    @Test
    void addBusinessDaysShouldThrowOnNull() {
        assertThrows(NullPointerException.class, () -> Ejercicio6.addBusinessDays(null, 1));
    }

    @Test
    void addBusinessDaysShouldThrowOnNegative() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio6.addBusinessDays(LocalDate.now(), -1));
    }

    @Test
    void addBusinessDaysShouldAddMultipleDays() {
        assertEquals(LocalDate.of(2026, 2, 12), Ejercicio6.addBusinessDays(LocalDate.of(2026, 2, 10), 2));
    }

}
