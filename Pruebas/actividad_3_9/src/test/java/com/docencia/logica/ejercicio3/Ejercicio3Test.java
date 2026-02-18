package com.docencia.logica.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Set;

import org.junit.jupiter.api.Test;

public final class Ejercicio3Test {
    // 1) Fecha laborable sin festivos -> devuelve la misma
    @Test
    void siguienteLaborable_viernesSinFestivos_devuelveMismaFecha() {
        Set<LocalDate> festivos = Set.of();
        assertEquals(LocalDate.of(2026, 2, 13),
                Ejercicio3.siguienteLaborable("13/02/2026", festivos));
    }

    // 2) Sábado -> salta a lunes (sin festivos)
    @Test
    void siguienteLaborable_sabado_saltaALunes() {
        Set<LocalDate> festivos = Set.of();
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio3.siguienteLaborable("14/02/2026", festivos));
    }

    // 3) Domingo -> salta a lunes (sin festivos)
    @Test
    void siguienteLaborable_domingo_saltaALunes() {
        Set<LocalDate> festivos = Set.of();
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio3.siguienteLaborable("15/02/2026", festivos));
    }

    // 4) Día es festivo (laborable) -> avanza 1 día
    @Test
    void siguienteLaborable_festivoEntreSemana_avanza() {
        Set<LocalDate> festivos = Set.of(LocalDate.of(2026, 2, 17)); // martes
        assertEquals(LocalDate.of(2026, 2, 18),
                Ejercicio3.siguienteLaborable("17/02/2026", festivos));
    }

    // 5) Festivos consecutivos + finde -> salta todo
    @Test
    void siguienteLaborable_findeMasFestivosConsecutivos_saltaHastaMiercoles() {
        Set<LocalDate> festivos = Set.of(
                LocalDate.of(2026, 2, 16), // lunes
                LocalDate.of(2026, 2, 17)  // martes
        );
        // 14 sáb -> 15 dom -> 16 fest -> 17 fest -> 18 mié
        assertEquals(LocalDate.of(2026, 2, 18),
                Ejercicio3.siguienteLaborable("14/02/2026", festivos));
    }

    // 6) Fecha inicial es viernes pero es festivo -> pasa a lunes (sin más festivos)
    @Test
    void siguienteLaborable_viernesFestivo_pasaALunes() {
        Set<LocalDate> festivos = Set.of(LocalDate.of(2026, 2, 13)); // viernes festivo
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio3.siguienteLaborable("13/02/2026", festivos));
    }

    // 7) Festivo cae en sábado: igual se trata como no laborable (salta al lunes)
    @Test
    void siguienteLaborable_sabadoFestivo_saltaALunes() {
        Set<LocalDate> festivos = Set.of(LocalDate.of(2026, 2, 14)); // sábado
        assertEquals(LocalDate.of(2026, 2, 16),
                Ejercicio3.siguienteLaborable("14/02/2026", festivos));
    }

    // 8) Fecha inválida (no existe) -> excepción
    @Test
    void siguienteLaborable_fechaInvalida_lanzaExcepcion() {
        Set<LocalDate> festivos = Set.of();
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio3.siguienteLaborable("31/04/2026", festivos));
    }

    // 9) fecha null -> excepción
    @Test
    void siguienteLaborable_fechaNull_lanzaExcepcion() {
        Set<LocalDate> festivos = Set.of();
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio3.siguienteLaborable(null, festivos));
    }

    // 10) festivos null -> excepción
    @Test
    void siguienteLaborable_festivosNull_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Ejercicio3.siguienteLaborable("13/02/2026", null));
    }
    }
