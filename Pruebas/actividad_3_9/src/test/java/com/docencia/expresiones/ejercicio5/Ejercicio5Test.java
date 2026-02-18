package com.docencia.expresiones.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public final class Ejercicio5Test {

    // 1) Válida con hora sin cero
    @Test
    void valida_horaSinCero_true() {
        assertTrue(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 9:30 AM"));
    }

    // 2) Válida con hora con cero (09)
    @Test
    void valida_horaConCero_true() {
        assertTrue(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 09:30 AM"));
    }

    // 3) Válida en el límite 12:00 PM
    @Test
    void valida_mediodia_true() {
        assertTrue(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 12:00 PM"));
    }

    // 4) Válida en el límite 11:59 PM
    @Test
    void valida_limiteNoche_true() {
        assertTrue(Ejercicio5.esFechaHora12hAmPmValida("31/01/2020 11:59 PM"));
    }

    // 5) Inválida: hora 00
    @Test
    void invalida_hora00_false() {
        assertFalse(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 00:30 AM"));
    }

    // 6) Inválida: hora 13
    @Test
    void invalida_hora13_false() {
        assertFalse(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 13:00 PM"));
    }

    // 7) Inválida: minutos 60
    @Test
    void invalida_minutos60_false() {
        assertFalse(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 9:60 AM"));
    }

    // 8) Inválida: mes 13
    @Test
    void invalida_mes13_false() {
        assertFalse(Ejercicio5.esFechaHora12hAmPmValida("13/13/2026 9:30 AM"));
    }

    // 9) Inválida: am en minúsculas
    @Test
    void invalida_ampmMinusculas_false() {
        assertFalse(Ejercicio5.esFechaHora12hAmPmValida("13/02/2026 9:30 am"));
    }

    // 10) Null -> false
    @Test
    void null_false() {
        assertFalse(Ejercicio5.esFechaHora12hAmPmValida(null));
    }

}
