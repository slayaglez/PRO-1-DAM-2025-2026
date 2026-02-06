/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con empleados y sus turnos
 */
package com.docencia.clases.ejercicio5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TurnoEmpleado {

    private static final String EMP_ID_REGEX = "^EMP-\\d{5}$";
    private static final String FRANJA_REGEX = "^\\d{2}:\\d{2}-\\d{2}:\\d{2}$";

    private final String empleadoId;
    private final LocalDate dia;
    private final LocalTime inicio;
    private final LocalTime fin;

    public TurnoEmpleado(String empleadoId, LocalDate dia, LocalTime inicio, LocalTime fin) {
        this.empleadoId = empleadoId;
        this.dia = dia;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void validate() {
        if (empleadoId == null || !empleadoId.matches(EMP_ID_REGEX)) {
            throw new IllegalArgumentException();
        }
        if (dia == null || inicio == null || fin == null) {
            throw new IllegalArgumentException();
        }
        if (inicio.equals(fin)) {
            throw new IllegalArgumentException();
        }
    }

    public String franja() {

        int horaInicio = inicio.getHour();
        int minutoInicio = inicio.getMinute();
        int horaFin = fin.getHour();
        int minutoFin = fin.getMinute();

        String horaInicioStr = "" + horaInicio;
        if (horaInicio < 10) {
            horaInicioStr = "0" + horaInicio;
        }
        String minutoInicioStr = "" + minutoInicio;
        if (minutoInicio < 10) {
            minutoInicioStr = "0" + minutoInicio;
        }
        String horaFinStr = "" + horaFin;
        if (horaFin < 10) {
            horaFinStr = "0" + horaFin;
        }
        String minutoFinStr = "" + minutoFin;
        if (minutoFin < 10) {
            minutoFinStr = "0" + minutoFin;
        }

        return horaInicioStr + ":" + minutoInicioStr + "-" + horaFinStr + ":" + minutoFinStr;
    }

    public LocalDateTime inicioDateTime() {
        return LocalDateTime.of(dia, inicio);
    }

    public LocalDateTime finDateTime() {
        if (fin.isBefore(inicio)) {
            return LocalDateTime.of(dia.plusDays(1), fin);
        }
        return LocalDateTime.of(dia, fin);
    }

    public boolean cumpleDescansoMinimoDesde(TurnoEmpleado anterior, int minDescansoHoras) {
        if (anterior == null) {
            return false;
        }
        LocalDateTime finAnterior = anterior.finDateTime();
        LocalDateTime inicioActual = this.inicioDateTime();
        if (!inicioActual.isAfter(finAnterior)) {
            return false;
        }

        //! SUPER UTIL -> para periodos entre tiempos
        long horasDescanso = Duration.between(finAnterior, inicioActual).toHours();
        return horasDescanso >= minDescansoHoras;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public LocalDate getDia() {
        return dia;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }
}
