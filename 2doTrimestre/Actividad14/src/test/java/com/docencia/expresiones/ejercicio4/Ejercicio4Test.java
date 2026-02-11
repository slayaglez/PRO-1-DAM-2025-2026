package com.docencia.expresiones.ejercicio4;

import org.junit.jupiter.api.Test;
import java.time.ZoneId;
import java.time.DateTimeException;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio4Test {

    @Test
    void parseZoneCommandShouldParseCanary() {
        assertEquals(ZoneId.of("Atlantic/Canary"), Ejercicio4.parseZoneCommand("SET TZ=Atlantic/Canary"));
    }

    @Test
    void parseZoneCommandShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio4.parseZoneCommand(null));
    }

    @Test
    void parseZoneCommandShouldThrowOnBlank() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio4.parseZoneCommand(" "));
    }

    @Test
    void parseZoneCommandShouldThrowOnWrongPrefix() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio4.parseZoneCommand("TZ=Atlantic/Canary"));
    }

    @Test
    void parseZoneCommandShouldThrowOnUnknownZone() {
        assertThrows(DateTimeException.class, () -> Ejercicio4.parseZoneCommand("SET TZ=Nope/Nowhere"));
    }
}
