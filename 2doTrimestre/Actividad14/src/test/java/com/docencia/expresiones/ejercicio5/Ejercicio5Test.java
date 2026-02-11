package com.docencia.expresiones.ejercicio5;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio5Test {

    @Test
    void parseLogInstantShouldParseOffsetDateTimeToInstant() {
        Instant i = Ejercicio5.parseLogInstant("[2026-02-10T14:35:20+00:00] user=42 action=login");
        assertEquals(Instant.parse("2026-02-10T14:35:20Z"), i);
    }

    @Test
    void parseLogInstantShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio5.parseLogInstant(null));
    }

    @Test
    void parseLogInstantShouldThrowOnBlank() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio5.parseLogInstant(" "));
    }

    @Test
    void parseLogInstantShouldThrowOnMissingBracket() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio5.parseLogInstant("2026-02-10T14:35:20+00:00 user=42"));
    }

    @Test
    void parseLogInstantShouldThrowOnUnparseableTimestamp() {
        assertThrows(DateTimeException.class, () -> Ejercicio5.parseLogInstant("[not-a-date] x"));
    }
}
