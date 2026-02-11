package com.docencia.fechas.ejercicio5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio5Test {

    @Test
    void ageYearsShouldReturn0WhenSameDay() {
        assertEquals(0, Ejercicio5.ageYears(LocalDate.of(2026, 2, 10), LocalDate.of(2026, 2, 10)));
    }

    @Test
    void ageYearsShouldComputeYears() {
        assertEquals(20, Ejercicio5.ageYears(LocalDate.of(2006, 2, 10), LocalDate.of(2026, 2, 10)));
    }

    @Test
    void ageYearsShouldThrowOnNullBirth() {
        assertThrows(NullPointerException.class, () -> Ejercicio5.ageYears(null, LocalDate.now()));
    }

    @Test
    void ageYearsShouldThrowOnNullToday() {
        assertThrows(NullPointerException.class, () -> Ejercicio5.ageYears(LocalDate.now(), null));
    }

    @Test
    void ageYearsShouldThrowWhenTodayBeforeBirth() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio5.ageYears(LocalDate.of(2026, 2, 10), LocalDate.of(2026, 2, 9)));
    }
}
