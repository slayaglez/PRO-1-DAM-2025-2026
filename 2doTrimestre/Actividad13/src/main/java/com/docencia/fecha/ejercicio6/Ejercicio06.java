/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida el descanso entre dos turnos
 */
package com.docencia.fecha.ejercicio6;

import java.time.LocalTime;

/**
 * EJERCICIO 6) Descanso mínimo entre turnos
 *
 * Dados finTurno e inicioSiguiente, determina si entre ambos hay al menos
 * minDescansoHoras horas.
 * El inicio del siguiente turno puede ser el mismo día o el día siguiente
 * (cruce de medianoche).
 *
 * Interpretación:
 * - Si inicioSiguiente es anterior a finTurno, se asume que inicioSiguiente es
 * al día siguiente.
 *
 * Programación defensiva:
 * - Si finTurno o inicioSiguiente son null, lanza IllegalArgumentException.
 * - Si minDescansoHoras <= 0 o minDescansoHoras > 24, lanza
 * IllegalArgumentException.
 *
 * Ejemplos (minDescansoHoras=12):
 * - fin=20:00, inicio=08:00 => true
 * - fin=20:00, inicio=06:00 => false
 */
public class Ejercicio06 {
    public static boolean cumpleDescanso(LocalTime finTurno, LocalTime inicioSiguiente, int minDescansoHoras) {
        
        if(finTurno == null || inicioSiguiente == null || minDescansoHoras <= 0 || minDescansoHoras > 24){
            throw new IllegalArgumentException();
        }
        if(finTurno.equals(inicioSiguiente)){
            return false;
        }

        int horasFin = finTurno.getHour();
        int minutosFin = finTurno.getMinute();

        int horasInicio = inicioSiguiente.getHour();
        int minutosInicio = inicioSiguiente.getMinute();

        int horasResultado = 0;
        int minutosResultado = 0;

        // entre fin e inicio deben haber 12 horas
        // si fin < inicio entonces es el mismo dia
        // luego inicio - fin >= min
        if(finTurno.isBefore(inicioSiguiente)){
            horasResultado = horasInicio - horasFin;
            minutosResultado = minutosInicio - minutosFin;
            // si hay overflow (minFin > minInicio)
            if(minutosResultado <0){
                horasResultado--;
            }
            return horasResultado >= minDescansoHoras;
        }
        // si por otro lado fin > inicio entonces cambio de día
        // luego calculo tiempo de fin -> 00:00 y de 00:00 a inicio
        // eso debe ser >= a min
        else {
            horasResultado = (24-horasFin) + horasInicio;
            minutosResultado = minutosFin + minutosFin;
            //si hay overflow (minResultado > 59)
            if(minutosResultado >= 60){
                horasResultado++;
            }
            return horasResultado >= minDescansoHoras;
        }
    }
}
