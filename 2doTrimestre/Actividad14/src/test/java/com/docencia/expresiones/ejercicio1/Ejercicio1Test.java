package com.docencia.expresiones.ejercicio1;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio1Test {

    @Test
    void parseIsoDateShouldParseValidDate() {
        assertEquals(LocalDate.of(2026, 2, 10), Ejercicio1.parseIsoDate("2026-02-10"));
    }

    @Test
    void parseIsoDateShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio1.parseIsoDate(null));
    }

    @Test
    void parseIsoDateShouldThrowOnBlank() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio1.parseIsoDate("   "));
    }

    @Test
    void parseIsoDateShouldThrowOnWrongFormat() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio1.parseIsoDate("10/02/2026"));
    }

    @Test
    void parseIsoDateShouldThrowOnInvalidDateValue() {
        assertThrows(DateTimeException.class, () -> Ejercicio1.parseIsoDate("2026-02-30"));
    }
}
