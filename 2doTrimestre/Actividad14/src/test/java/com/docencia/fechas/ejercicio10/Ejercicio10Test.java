package com.docencia.fechas.ejercicio10;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio10Test {

    @Test
    void minutesBetweenWithWrapShouldComputeSameDayDifference() {
        assertEquals(30L, Ejercicio10.minutesBetweenWithWrap(LocalTime.of(10, 0), LocalTime.of(10, 30)));
    }

    @Test
    void minutesBetweenWithWrapShouldComputeWrapDifference() {
        assertEquals(45L, Ejercicio10.minutesBetweenWithWrap(LocalTime.of(23, 30), LocalTime.of(0, 15)));
    }

    @Test
    void minutesBetweenWithWrapShouldReturn0WhenEqual() {
        assertEquals(0L, Ejercicio10.minutesBetweenWithWrap(LocalTime.of(9, 0), LocalTime.of(9, 0)));
    }

    @Test
    void minutesBetweenWithWrapShouldThrowOnNullStart() {
        assertThrows(NullPointerException.class, () -> Ejercicio10.minutesBetweenWithWrap(null, LocalTime.NOON));
    }

    @Test
    void minutesBetweenWithWrapShouldThrowOnNullEnd() {
        assertThrows(NullPointerException.class, () -> Ejercicio10.minutesBetweenWithWrap(LocalTime.NOON, null));
    }
}
