package com.docencia.fechas.ejercicio3;

import org.junit.jupiter.api.Test;
import java.time.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio3Test {

    @Test
    void buildAppointmentCheckedShouldReturnAppointmentWhenNotPast() {
        LocalDateTime now = LocalDateTime.of(2026, 2, 10, 8, 0);
        assertEquals(LocalDateTime.of(2026, 2, 10, 9, 0),
                Ejercicio3.buildAppointmentChecked(LocalDate.of(2026, 2, 10), LocalTime.of(9, 0), now));
    }

    @Test
    void buildAppointmentCheckedShouldThrowWhenPast() {
        LocalDateTime now = LocalDateTime.of(2026, 2, 10, 10, 0);
        assertThrows(IllegalArgumentException.class, () ->
                Ejercicio3.buildAppointmentChecked(LocalDate.of(2026, 2, 10), LocalTime.of(9, 0), now));
    }

    @Test
    void buildAppointmentCheckedShouldThrowOnNullDate() {
        assertThrows(NullPointerException.class, () ->
                Ejercicio3.buildAppointmentChecked(null, LocalTime.NOON, LocalDateTime.now()));
    }

    @Test
    void buildAppointmentCheckedShouldThrowOnNullTime() {
        assertThrows(NullPointerException.class, () ->
                Ejercicio3.buildAppointmentChecked(LocalDate.now(), null, LocalDateTime.now()));
    }

    @Test
    void buildAppointmentCheckedShouldThrowOnNullNow() {
        assertThrows(NullPointerException.class, () ->
                Ejercicio3.buildAppointmentChecked(LocalDate.now(), LocalTime.NOON, null));
    }
}
