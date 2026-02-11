package com.docencia.expresiones.ejercicio3;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio3Test {

    @Test
    void parseFlexibleLocalDateTimeShouldParseWithSpaceSeparator() {
        assertEquals(LocalDateTime.of(2026, 2, 10, 9, 0), Ejercicio3.parseFlexibleLocalDateTime("2026-02-10 09:00"));
    }

    @Test
    void parseFlexibleLocalDateTimeShouldParseWithTSeparator() {
        assertEquals(LocalDateTime.of(2026, 2, 10, 9, 0), Ejercicio3.parseFlexibleLocalDateTime("2026-02-10T09:00"));
    }

    @Test
    void parseFlexibleLocalDateTimeShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio3.parseFlexibleLocalDateTime(null));
    }

    @Test
    void parseFlexibleLocalDateTimeShouldThrowOnWrongFormat() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio3.parseFlexibleLocalDateTime("2026/02/10 09:00"));
    }

    @Test
    void parseFlexibleLocalDateTimeShouldThrowOnInvalidTime() {
        assertThrows(DateTimeException.class, () -> Ejercicio3.parseFlexibleLocalDateTime("2026-02-10 25:00"));
    }
}
