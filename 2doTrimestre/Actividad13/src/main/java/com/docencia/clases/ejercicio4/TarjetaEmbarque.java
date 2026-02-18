/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que calcula y trabaja horarios de un vuelo
 */
package com.docencia.clases.ejercicio4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class TarjetaEmbarque {

    private final String codigo;
    private final LocalDate fechaVuelo;
    private final LocalTime horaSalida;

    public TarjetaEmbarque(String codigo, LocalDate fechaVuelo, LocalTime horaSalida) {
        this.codigo = codigo;
        this.fechaVuelo = fechaVuelo;
        this.horaSalida = horaSalida;
    }

    public void validate(LocalDate hoy) {
        if (hoy == null || this.codigo == null) {
            throw new IllegalArgumentException();
        }

        // BP-IB-2026-A1B2C3
        String patron = "^[A-Z]{2}-[A-Z]{2}-[0-9]{4}-[A-Z0-9]{6}$";
        if (!Pattern.matches(patron, this.codigo)) {
            throw new IllegalArgumentException();
        }

        if (fechaVuelo.isBefore(hoy)) {
            throw new IllegalArgumentException("vuelo pasado");
        }

    }

    public boolean puedeEmbarcar(LocalDate hoy, LocalTime ahora) {

        if (ahora == null) {
            throw new IllegalArgumentException();
        }

        if (!fechaVuelo.isEqual(hoy)) {
            return false;
        }

        LocalTime apertura = horaSalida.minusMinutes(45); // 45 min antes
        LocalTime cierre = horaSalida.minusMinutes(10); // 10 min dspues

        // mismo dia
        if (apertura.isBefore(cierre)) {
            return !ahora.isBefore(apertura) && ahora.isBefore(cierre);
        }
        // pasan las 00:00
        else {
            return !ahora.isBefore(apertura) || ahora.isBefore(cierre);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }
}
