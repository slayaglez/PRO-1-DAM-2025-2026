package com.docencia.logica.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import org.junit.jupiter.api.Test;

public final class Ejercicio2Test {

// 1) Cumpleaños hoy -> edad exacta
    @Test
    void edad_cumpleHoy_ok() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertEquals(26, Ejercicio2.calcularEdad("13/02/2000", hoy));
    }

    // 2) Todavía no cumple este año -> resta 1
    @Test
    void edad_noHaCumplidoEsteAnio_ok() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertEquals(25, Ejercicio2.calcularEdad("14/02/2000", hoy));
    }

    // 3) Ya cumplió este año -> edad normal
    @Test
    void edad_yaCumplioEsteAnio_ok() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertEquals(26, Ejercicio2.calcularEdad("12/02/2000", hoy));
    }

    // 4) Bisiesto: 29/02 válido
    @Test
    void edad_bisiesto_29Feb_ok() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertEquals(21, Ejercicio2.calcularEdad("29/02/2004", hoy));
    }

    // 5) Fecha inválida: 31/04 no existe
    @Test
    void edad_fechaInexistente_31Abril_lanzaExcepcion() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio2.calcularEdad("31/04/2000", hoy));
    }

    // 6) Fecha inválida: 29/02 en no bisiesto
    @Test
    void edad_fechaInexistente_29FebNoBisiesto_lanzaExcepcion() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio2.calcularEdad("29/02/2023", hoy));
    }

    // 7) Nacimiento en el futuro respecto a hoy
    @Test
    void edad_nacimientoFuturo_lanzaExcepcion() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio2.calcularEdad("14/02/2030", hoy));
    }

    // 8) Formato inválido
    @Test
    void edad_formatoIncorrecto_lanzaExcepcion() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio2.calcularEdad("2000-02-13", hoy));
    }

    // 9) nacimiento null
    @Test
    void edad_nacimientoNull_lanzaExcepcion() {
        LocalDate hoy = LocalDate.of(2026, 2, 13);
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio2.calcularEdad(null, hoy));
    }

    // 10) hoy null
    @Test
    void edad_hoyNull_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio2.calcularEdad("13/02/2000", null));
    }
    
}
