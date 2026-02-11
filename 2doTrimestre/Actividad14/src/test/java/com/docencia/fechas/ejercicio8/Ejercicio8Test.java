package com.docencia.fechas.ejercicio8;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio8Test {

    @Test
    void processingDateByCutoffShouldProcessSameDayWhenBeforeCutoff() {
        assertEquals(LocalDate.of(2026, 2, 10),
                Ejercicio8.processingDateByCutoff(LocalDateTime.of(2026, 2, 10, 17, 0), LocalTime.of(18, 0)));
    }

    @Test
    void processingDateByCutoffShouldProcessNextDayWhenAfterCutoff() {
        assertEquals(LocalDate.of(2026, 2, 11),
                Ejercicio8.processingDateByCutoff(LocalDateTime.of(2026, 2, 10, 18, 1), LocalTime.of(18, 0)));
    }

    @Test
    void processingDateByCutoffShouldThrowOnNullReceived() {
        assertThrows(NullPointerException.class, () -> Ejercicio8.processingDateByCutoff(null, LocalTime.NOON));
    }

    @Test
    void processingDateByCutoffShouldThrowOnNullCutoff() {
        assertThrows(NullPointerException.class, () -> Ejercicio8.processingDateByCutoff(LocalDateTime.now(), null));
    }

    @Test
    void processingDateByCutoffShouldTreatEqualCutoffAsSameDay() {
        assertEquals(LocalDate.of(2026, 2, 10),
                Ejercicio8.processingDateByCutoff(LocalDateTime.of(2026, 2, 10, 18, 0), LocalTime.of(18, 0)));
    }
}
