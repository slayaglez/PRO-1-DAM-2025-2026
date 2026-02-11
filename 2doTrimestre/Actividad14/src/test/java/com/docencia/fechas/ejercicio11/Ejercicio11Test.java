package com.docencia.fechas.ejercicio11;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio11Test {

    @Test
    void toUserZoneSameInstantShouldConvertAndKeepInstant() {
        ZonedDateTime z = Ejercicio11.toUserZoneSameInstant(
                LocalDateTime.of(2026, 2, 10, 10, 0),
                ZoneId.of("Atlantic/Canary"),
                ZoneId.of("UTC"));
        assertEquals(ZoneId.of("UTC"), z.getZone());
    }

    @Test
    void toUserZoneSameInstantShouldThrowOnNullMeeting() {
        assertThrows(NullPointerException.class, () -> Ejercicio11.toUserZoneSameInstant(null, ZoneId.of("UTC"), ZoneId.of("UTC")));
    }

    @Test
    void toUserZoneSameInstantShouldThrowOnNullOrigin() {
        assertThrows(NullPointerException.class, () -> Ejercicio11.toUserZoneSameInstant(LocalDateTime.now(), null, ZoneId.of("UTC")));
    }

    @Test
    void toUserZoneSameInstantShouldThrowOnNullTarget() {
        assertThrows(NullPointerException.class, () -> Ejercicio11.toUserZoneSameInstant(LocalDateTime.now(), ZoneId.of("UTC"), null));
    }

    @Test
    void toUserZoneSameInstantShouldProduceSameInstantAsOrigin() {
        LocalDateTime ldt = LocalDateTime.of(2026, 2, 10, 10, 0);
        ZonedDateTime origin = ldt.atZone(ZoneId.of("Atlantic/Canary"));
        ZonedDateTime target = Ejercicio11.toUserZoneSameInstant(ldt, ZoneId.of("Atlantic/Canary"), ZoneId.of("UTC"));
        assertEquals(origin.toInstant(), target.toInstant());
    }
}
