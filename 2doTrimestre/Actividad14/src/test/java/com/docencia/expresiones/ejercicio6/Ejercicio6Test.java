package com.docencia.expresiones.ejercicio6;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio6Test {

    @Test
    void applyDeltaCommandShouldAddDays() {
        LocalDateTime base = LocalDateTime.of(2026, 2, 10, 9, 0);
        assertEquals(LocalDateTime.of(2026, 2, 13, 9, 0), Ejercicio6.applyDeltaCommand(base, "+3d"));
    }

    @Test
    void applyDeltaCommandShouldSubtractHours() {
        LocalDateTime base = LocalDateTime.of(2026, 2, 10, 9, 0);
        assertEquals(LocalDateTime.of(2026, 2, 10, 7, 0), Ejercicio6.applyDeltaCommand(base, "-2h"));
    }

    @Test
    void applyDeltaCommandShouldThrowOnNullBase() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio6.applyDeltaCommand(null, "+1d"));
    }

    @Test
    void applyDeltaCommandShouldThrowOnBlankCommand() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio6.applyDeltaCommand(LocalDateTime.now(), " "));
    }

    @Test
    void applyDeltaCommandShouldThrowOnInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio6.applyDeltaCommand(LocalDateTime.now(), "+5x"));
    }
}
