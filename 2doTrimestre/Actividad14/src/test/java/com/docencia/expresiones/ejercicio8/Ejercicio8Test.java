package com.docencia.expresiones.ejercicio8;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio8Test {

    @Test
    void countEventsByDayShouldCountTwoDays() {
        Map<LocalDate, Long> m = Ejercicio8.countEventsByDay("A(2026-02-10 09:00), B(2026-02-10 12:30), C(2026-02-11 09:15)");
        assertEquals(2, m.size());
    }

    @Test
    void countEventsByDayShouldCountTwoEventsSameDay() {
        Map<LocalDate, Long> m = Ejercicio8.countEventsByDay("A(2026-02-10 09:00), B(2026-02-10 12:30)");
        assertEquals(2L, m.get(LocalDate.of(2026, 2, 10)));
    }

    @Test
    void countEventsByDayShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio8.countEventsByDay(null));
    }

    @Test
    void countEventsByDayShouldThrowOnBlank() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio8.countEventsByDay(" "));
    }

    @Test
    void countEventsByDayShouldThrowWhenNoEventsFound() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio8.countEventsByDay("sin paréntesis"));
    }
}
