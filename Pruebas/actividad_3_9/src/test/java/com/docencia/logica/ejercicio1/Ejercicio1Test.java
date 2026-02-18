package com.docencia.logica.ejercicio1;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Objects;

import org.junit.jupiter.api.Test;

public final class Ejercicio1Test {

    // 1) Dentro del intervalo (caso típico)
    @Test
    void dentroHorario_casoTipico_true() {
        assertTrue(Ejercicio1.estaDentroHorario("09:30",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 2) Igual al inicio (incluido)
    @Test
    void dentroHorario_igualInicio_true() {
        assertTrue(Ejercicio1.estaDentroHorario("09:00",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 3) Igual al fin (incluido)
    @Test
    void dentroHorario_igualFin_true() {
        assertTrue(Ejercicio1.estaDentroHorario("18:00",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 4) Fuera por arriba
    @Test
    void fueraHorario_porArriba_false() {
        assertFalse(Ejercicio1.estaDentroHorario("18:01",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 5) Fuera por abajo
    @Test
    void fueraHorario_porAbajo_false() {
        assertFalse(Ejercicio1.estaDentroHorario("07:59",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 6) Hora inválida (24:00)
    @Test
    void horaInvalida_2400_false() {
        assertFalse(Ejercicio1.estaDentroHorario("24:00",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 7) Formato inválido (sin cero a la izquierda)
    @Test
    void formatoInvalido_sinCero_false() {
        assertFalse(Ejercicio1.estaDentroHorario("9:00",
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 8) Intervalo de un solo instante (inicio == fin) y coincide
    @Test
    void intervaloPunto_yCoincide_true() {
        assertTrue(Ejercicio1.estaDentroHorario("00:00",
                LocalTime.of(0, 0),
                LocalTime.of(0, 0)));
    }

    // 9) Null en hora
    @Test
    void nullHora_false() {
        assertFalse(Ejercicio1.estaDentroHorario(null,
                LocalTime.of(9, 0),
                LocalTime.of(18, 0)));
    }

    // 10) Null en inicio (o fin)
    @Test
    void nullInicio_false() {
        assertFalse(Ejercicio1.estaDentroHorario("10:00",
                null,
                LocalTime.of(18, 0)));
    }
}
