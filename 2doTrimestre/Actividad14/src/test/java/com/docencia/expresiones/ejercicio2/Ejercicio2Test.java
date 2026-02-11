package com.docencia.expresiones.ejercicio2;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio2Test {

    @Test
    void extractFirstTimeShouldFindTimeInText() {
        assertEquals(LocalTime.of(9, 30), Ejercicio2.extractFirstTime("La cita es a las 09:30 en recepción"));
    }

    @Test
    void extractFirstTimeShouldThrowOnNull() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio2.extractFirstTime(null));
    }

    @Test
    void extractFirstTimeShouldThrowOnBlank() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio2.extractFirstTime(" "));
    }

    @Test
    void extractFirstTimeShouldThrowWhenNoTimeFound() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio2.extractFirstTime("No hay hora aquí"));
    }

    @Test
    void extractFirstTimeShouldRejectInvalidHour() {
        assertThrows(IllegalArgumentException.class, () -> Ejercicio2.extractFirstTime("Hora 29:10 imposible"));
    }
}
