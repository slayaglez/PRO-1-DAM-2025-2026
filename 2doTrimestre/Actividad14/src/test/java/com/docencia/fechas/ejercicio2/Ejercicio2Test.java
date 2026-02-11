package com.docencia.fechas.ejercicio2;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio2Test {

    @Test
    void roundDownToStepShouldRoundDownToQuarterHour() {
        assertEquals(LocalTime.of(10, 15), Ejercicio2.roundDownToStep(LocalTime.of(10, 29), 15));
    }

    @Test
    void roundDownToStepShouldKeepExactBoundary() {
        assertEquals(LocalTime.of(10, 30), Ejercicio2.roundDownToStep(LocalTime.of(10, 30), 15));
    }

    @Test
    void roundDownToStepShouldThrowOnNull() {
        assertThrows(NullPointerException.class, () -> Ejercicio2.roundDownToStep(null, 15));
    }

    @Test
    void roundDownToStepShouldThrowOnBadStep() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio2.roundDownToStep(LocalTime.NOON, 0));
    }

    @Test
    void roundDownToStepShouldZeroSecondsAndNanos() {
        assertEquals(0, Ejercicio2.roundDownToStep(LocalTime.of(10, 29, 59, 999), 15).getSecond());
    }
}
