package com.docencia.fechas.ejercicio12;

import org.junit.jupiter.api.Test;
import com.docencia.fechas.EventComparison;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio12Test {

    @Test
    void compareEventsShouldIdentifyFirst() {
        ZonedDateTime a = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime b = a.plusMinutes(5);
        assertEquals(a, Ejercicio12.compareEvents(a, b).first());
    }

    @Test
    void compareEventsShouldHaveZeroWhenSameInstant() {
        ZonedDateTime a = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        assertEquals(Duration.ZERO, Ejercicio12.compareEvents(a, a).absoluteDifference());
    }

    @Test
    void compareEventsShouldThrowOnNullA() {
        assertThrows(NullPointerException.class, () -> Ejercicio12.compareEvents(null, ZonedDateTime.now(ZoneId.of("UTC"))));
    }

    @Test
    void compareEventsShouldThrowOnNullB() {
        assertThrows(NullPointerException.class, () -> Ejercicio12.compareEvents(ZonedDateTime.now(ZoneId.of("UTC")), null));
    }

    @Test
    void compareEventsShouldReturnAbsoluteDifference() {
        ZonedDateTime a = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime b = a.minusMinutes(7);
        assertEquals(Duration.ofMinutes(7), Ejercicio12.compareEvents(a, b).absoluteDifference());
    }
}
