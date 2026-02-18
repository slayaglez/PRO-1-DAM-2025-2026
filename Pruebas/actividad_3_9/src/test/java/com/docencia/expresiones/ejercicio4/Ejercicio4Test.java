package com.docencia.expresiones.ejercicio4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Pattern;

import javax.print.attribute.standard.MediaSize.ISO;

import org.junit.jupiter.api.Test;

public final class Ejercicio4Test {

@Test
    void isoSoloFecha_valida_true() {
        assertTrue(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-13"));
    }

    // 2) Fecha + hora válida
    @Test
    void isoConHora_valida_true() {
        assertTrue(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-13 14:30"));
    }

    // 3) Hora mínima válida
    @Test
    void isoConHora_horaMinima_true() {
        assertTrue(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-13 00:00"));
    }

    // 4) Hora máxima válida
    @Test
    void isoConHora_horaMaxima_true() {
        assertTrue(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-13 23:59"));
    }

    // 5) Mes inválido 13
    @Test
    void isoMesInvalido_13_false() {
        assertFalse(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-13-01"));
    }

    // 6) Mes inválido 00
    @Test
    void isoMesInvalido_00_false() {
        assertFalse(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-00-10"));
    }

    // 7) Día inválido 32
    @Test
    void isoDiaInvalido_32_false() {
        assertFalse(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-32"));
    }

    // 8) Hora inválida 24:00
    @Test
    void isoHoraInvalida_2400_false() {
        assertFalse(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-13 24:00"));
    }

    // 9) Separador incorrecto (T)
    @Test
    void isoSeparadorIncorrecto_conT_false() {
        assertFalse(Ejercicio4.esFechaIsoConHoraOpcionalValida("2026-02-13T14:30"));
    }

    // 10) Null -> false
    @Test
    void isoNull_false() {
        assertFalse(Ejercicio4.esFechaIsoConHoraOpcionalValida(null));
    }

}
