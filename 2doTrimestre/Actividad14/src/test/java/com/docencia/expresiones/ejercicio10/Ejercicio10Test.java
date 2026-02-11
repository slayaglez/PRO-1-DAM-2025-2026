package com.docencia.expresiones.ejercicio10;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio10Test {

    @Test
    void parseReminderToInstantShouldParseLocalWithZone() {
        Instant i = Ejercicio10.parseReminderToInstant(
                "remind 2026-02-10 18:00 TZ=Europe/Madrid",
                ZonedDateTime.of(2026, 2, 10, 0, 0, 0, 0, ZoneId.of("UTC")),
                ZoneId.of("Atlantic/Canary")
        );
        assertNotNull(i);
    }

    @Test
    void parseReminderToInstantShouldParseInMinutes() {
        ZonedDateTime now = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("UTC"));
        Instant i = Ejercicio10.parseReminderToInstant("remind in 90m", now, ZoneId.of("UTC"));
        assertEquals(now.toInstant().plus(Duration.ofMinutes(90)), i);
    }

    @Test
    void parseReminderToInstantShouldParseUtcWithoutSeconds() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        Instant i = Ejercicio10.parseReminderToInstant("remind 2026-02-10T18:00Z", now, ZoneId.of("UTC"));
        assertEquals(Instant.parse("2026-02-10T18:00:00Z"), i);
    }

    @Test
    void parseReminderToInstantShouldThrowOnNullInput() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        assertThrows(IllegalArgumentException.class, () -> Ejercicio10.parseReminderToInstant(null, now, ZoneId.of("UTC")));
    }

    @Test
    void parseReminderToInstantShouldThrowOnUnsupportedFormat() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        assertThrows(IllegalArgumentException.class, () -> Ejercicio10.parseReminderToInstant("remind tomorrow", now, ZoneId.of("UTC")));
    }
}
