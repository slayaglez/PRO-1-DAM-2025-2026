package com.docencia.logica.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Set;

import org.junit.jupiter.api.Test;

public final class Ejercicio4Test {

        // 1) Lunes -> laborable
    @Test
    void lunes_true() {
        assertTrue(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 16))); // lunes
    }

    // 2) Martes -> laborable
    @Test
    void martes_true() {
        assertTrue(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 17))); // martes
    }

    // 3) Miércoles -> laborable
    @Test
    void miercoles_true() {
        assertTrue(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 18))); // miércoles
    }

    // 4) Jueves -> laborable
    @Test
    void jueves_true() {
        assertTrue(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 19))); // jueves
    }

    // 5) Viernes -> laborable
    @Test
    void viernes_true() {
        assertTrue(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 20))); // viernes
    }

    // 6) Sábado -> no laborable
    @Test
    void sabado_false() {
        assertFalse(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 14))); // sábado
    }

    // 7) Domingo -> no laborable
    @Test
    void domingo_false() {
        assertFalse(Ejercicio4.esLaborable(LocalDate.of(2026, 2, 15))); // domingo
    }

    // 8) Otra fecha cualquiera en lunes -> true
    @Test
    void otroLunes_true() {
        assertTrue(Ejercicio4.esLaborable(LocalDate.of(2025, 11, 3))); // lunes
    }

    // 9) Fecha en sábado (otro mes/año) -> false
    @Test
    void otroSabado_false() {
        assertFalse(Ejercicio4.esLaborable(LocalDate.of(2026, 3, 7))); // sábado
    }

    // 10) (Opcional) null: el método actual lanzará NullPointerException
    // Si deseas que devuelva false con null, habría que modificar el método.
    @Test
    void null_lanzaNullPointerException() {
        assertThrows(NullPointerException.class, () -> Ejercicio4.esLaborable(null));
    }
    
}
