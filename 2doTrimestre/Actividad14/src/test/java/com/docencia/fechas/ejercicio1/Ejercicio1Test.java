package com.docencia.fechas.ejercicio1;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio1Test {

    @Test
    void labelDayShouldReturnLaborableForMonday() {
        assertEquals("LABORABLE", Ejercicio1.labelDay(LocalDate.of(2026, 2, 9)));
    }

    @Test
    void labelDayShouldReturnWeekendForSunday() {
        assertEquals("FIN_DE_SEMANA", Ejercicio1.labelDay(LocalDate.of(2026, 2, 8)));
    }

    @Test
    void labelDayShouldThrowOnNull() {
        assertThrows(NullPointerException.class, () -> Ejercicio1.labelDay(null));
    }

    @Test
    void labelDayShouldReturnWeekendForSaturday() {
        assertEquals("FIN_DE_SEMANA", Ejercicio1.labelDay(LocalDate.of(2026, 2, 7)));
    }

    @Test
    void labelDayShouldReturnLaborableForFriday() {
        assertEquals("LABORABLE", Ejercicio1.labelDay(LocalDate.of(2026, 2, 6)));
    }
}
