package com.docencia.logica.ejercicio5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import org.junit.jupiter.api.Test;

public final class Ejercicio5Test {

      @Test
    void sumar_n0_devuelveMismaFechaAunqueSeaFinde() {
        assertEquals(LocalDate.of(2026, 2, 14), // sábado
                Ejercicio5.sumarDiasLaborables("14/02/2026", 0));
    }

    @Test
    void sumar_viernes_mas1_llegaALunes() {
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio5.sumarDiasLaborables("13/02/2026", 1));
    }

    @Test
    void sumar_viernes_mas2_llegaAMartes() {
        assertEquals(LocalDate.of(2026, 2, 17),
                Ejercicio5.sumarDiasLaborables("13/02/2026", 2));
    }

    @Test
    void sumar_sabado_mas1_llegaALunes() {
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio5.sumarDiasLaborables("14/02/2026", 1));
    }

    @Test
    void sumar_domingo_mas1_llegaALunes() {
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio5.sumarDiasLaborables("15/02/2026", 1));
    }

    @Test
    void sumar_lunes_mas5_llegaALunesSiguiente() {
        // 16 (lun) + 5 laborables -> 23 (lun)
        assertEquals(LocalDate.of(2026, 2, 23),
                Ejercicio5.sumarDiasLaborables("16/02/2026", 5));
    }

    @Test
    void sumar_cruzaUnFinde_llegaCorrecto() {
        // 19 (jue) + 2 laborables -> 23 (lun) (20 vie cuenta 1, 21-22 finde, 23 lun cuenta 2)
        assertEquals(LocalDate.of(2026, 2, 23),
                Ejercicio5.sumarDiasLaborables("19/02/2026", 2));
    }

    @Test
    void sumar_fechaInvalida_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio5.sumarDiasLaborables("31/04/2026", 1));
    }

    @Test
    void sumar_nNegativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio5.sumarDiasLaborables("13/02/2026", -1));
    }

    @Test
    void sumar_fechaNull_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio5.sumarDiasLaborables(null, 1));
    }
}
