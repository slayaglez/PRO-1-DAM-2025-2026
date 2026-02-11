package com.docencia.fechas.ejercicio14;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio14Test {

    @Test
    void overlapDurationShouldReturnFalseWhenNoOverlap() {
        ZonedDateTime a1 = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime a2 = a1.plusHours(1);
        ZonedDateTime b1 = a2.plusMinutes(1);
        ZonedDateTime b2 = b1.plusHours(1);
        assertFalse(Ejercicio14.overlapDuration(a1, a2, b1, b2).overlaps());
    }

    @Test
    void overlapDurationShouldReturnTrueWhenOverlap() {
        ZonedDateTime a1 = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime a2 = a1.plusHours(2);
        ZonedDateTime b1 = a1.plusHours(1);
        ZonedDateTime b2 = a1.plusHours(3);
        assertTrue(Ejercicio14.overlapDuration(a1, a2, b1, b2).overlaps());
    }

    @Test
    void overlapDurationShouldComputeOverlapDuration() {
        ZonedDateTime a1 = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        ZonedDateTime a2 = a1.plusHours(2);
        ZonedDateTime b1 = a1.plusHours(1);
        ZonedDateTime b2 = a1.plusHours(3);
        assertEquals(Duration.ofHours(1), Ejercicio14.overlapDuration(a1, a2, b1, b2).overlapDuration());
    }

    @Test
    void overlapDurationShouldThrowOnNullStart1() {
        ZonedDateTime t = ZonedDateTime.now(ZoneId.of("UTC"));
        assertThrows(NullPointerException.class, () -> Ejercicio14.overlapDuration(null, t, t, t.plusHours(1)));
    }

    @Test
    void overlapDurationShouldThrowWhenStartAfterEnd() {
        ZonedDateTime t = ZonedDateTime.now(ZoneId.of("UTC"));
        assertThrows(IllegalArgumentException.class, () -> Ejercicio14.overlapDuration(t.plusHours(1), t, t, t.plusHours(2)));
    }
}
