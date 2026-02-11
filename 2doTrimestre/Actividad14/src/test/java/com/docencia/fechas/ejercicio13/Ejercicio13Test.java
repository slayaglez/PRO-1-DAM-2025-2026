package com.docencia.fechas.ejercicio13;

import org.junit.jupiter.api.Test;
import com.docencia.fechas.TimeWindow;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio13Test {

    @Test
    void convertDailyAvailabilityShouldReturnNonNullWindow() {
        TimeWindow w = Ejercicio13.convertDailyAvailability(LocalDate.of(2026, 2, 10), LocalTime.of(9, 0), LocalTime.of(10, 0),
                ZoneId.of("Europe/Madrid"), ZoneId.of("Atlantic/Canary"));
        assertNotNull(w);
    }

    @Test
    void convertDailyAvailabilityShouldThrowOnNullDate() {
        assertThrows(NullPointerException.class, () -> Ejercicio13.convertDailyAvailability(null, LocalTime.NOON, LocalTime.NOON, ZoneId.of("UTC"), ZoneId.of("UTC")));
    }

    @Test
    void convertDailyAvailabilityShouldThrowOnNullFrom() {
        assertThrows(NullPointerException.class, () -> Ejercicio13.convertDailyAvailability(LocalDate.now(), null, LocalTime.NOON, ZoneId.of("UTC"), ZoneId.of("UTC")));
    }

    @Test
    void convertDailyAvailabilityShouldThrowOnNullOriginZone() {
        assertThrows(NullPointerException.class, () -> Ejercicio13.convertDailyAvailability(LocalDate.now(), LocalTime.NOON, LocalTime.NOON, null, ZoneId.of("UTC")));
    }

    @Test
    void convertDailyAvailabilityShouldPreserveInstantForStart() {
        LocalDate date = LocalDate.of(2026, 2, 10);
        LocalTime from = LocalTime.of(9, 0);
        ZoneId origin = ZoneId.of("Europe/Madrid");
        ZoneId target = ZoneId.of("UTC");
        TimeWindow w = Ejercicio13.convertDailyAvailability(date, from, LocalTime.of(10, 0), origin, target);
        assertEquals(LocalDateTime.of(date, from).atZone(origin).toInstant(), w.start().toInstant());
    }
}
