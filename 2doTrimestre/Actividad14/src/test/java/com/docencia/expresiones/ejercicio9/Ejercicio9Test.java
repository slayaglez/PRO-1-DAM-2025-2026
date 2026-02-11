package com.docencia.expresiones.ejercicio9;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio9Test {

    @Test
    void isOpenFromConfigShouldReturnTrueWithinWindow() {
        ZonedDateTime now = ZonedDateTime.of(2026, 2, 10, 10, 0, 0, 0, ZoneId.of("Atlantic/Canary"));
        assertTrue(Ejercicio9.isOpenFromConfig("OPEN=09:00 CLOSE=18:00 TZ=Atlantic/Canary", now));
    }

    @Test
    void isOpenFromConfigShouldReturnFalseOutsideWindow() {
        ZonedDateTime now = ZonedDateTime.of(2026, 2, 10, 20, 0, 0, 0, ZoneId.of("Atlantic/Canary"));
        assertFalse(Ejercicio9.isOpenFromConfig("OPEN=09:00 CLOSE=18:00 TZ=Atlantic/Canary", now));
    }

    @Test
    void isOpenFromConfigShouldThrowOnNullConfig() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Atlantic/Canary"));
        assertThrows(IllegalArgumentException.class, () -> Ejercicio9.isOpenFromConfig(null, now));
    }

    @Test
    void isOpenFromConfigShouldThrowOnNullNow() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio9.isOpenFromConfig("OPEN=09:00 CLOSE=18:00 TZ=Atlantic/Canary", null));
    }

    @Test
    void isOpenFromConfigShouldThrowOnBadConfigFormat() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Atlantic/Canary"));
        assertThrows(IllegalArgumentException.class, () -> Ejercicio9.isOpenFromConfig("OPEN=9 CLOSE=18 TZ=Atlantic/Canary", now));
    }
}
