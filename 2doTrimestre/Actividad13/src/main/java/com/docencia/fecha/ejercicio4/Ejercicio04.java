/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que redondea minutos segun el multiplo de un numero dado
 */
package com.docencia.fecha.ejercicio4;

import java.time.LocalTime;

/**
 * EJERCICIO 4) Redondear al siguiente múltiplo de X minutos (ceil)
 *
 * Dada una hora t y un paso en minutos pasoMin (por ejemplo 15), devuelve la
 * hora redondeada hacia arriba al siguiente múltiplo de pasoMin. - Si t ya cae
 * exactamente en un múltiplo, debe devolver t. - Si el redondeo supera las
 * 23:59, debe "pasar" al día siguiente (mod 24h).
 *
 * Programación defensiva: - Si t es null, lanza IllegalArgumentException. - Si
 * pasoMin <= 0 o pasoMin > 60, lanza IllegalArgumentException. - Recomendado:
 * exigir que 60 % pasoMin == 0 (si no, documenta tu estrategia).
 *
 * Ejemplos (pasoMin=15): - 10:01 => 10:15 - 10:15 => 10:15 - 10:59 => 11:00
 */
public class Ejercicio04 {

    public static LocalTime redondearArriba(LocalTime t, int pasoMin) {

        if(t == null || pasoMin <= 0 || pasoMin > 59 || 60 % pasoMin != 0){
            throw new IllegalArgumentException();
        }

        // vale, debo devolver los minutos como un multiplo de pasoMin
        // se me ocurre coger minutos de t
        // si minutos == pasoMin return la hora tal cual (hh:mm) o (hh:xx)
        // si minutos < pasoMin return la hora con pasoMin (hh:xx) misma cconsecuencia que arriba realmente
        // si minutos > pasoMin multiplico pasoMin por un incremental hasta que minutos <= pasoMin

        int horas = t.getHour();
        int minutos = t.getMinute();
        int segundos = t.getSecond();
        int nano = t.getNano();
        if(nano > 0 || segundos > 0){
            minutos++;
        }

        if(minutos <= pasoMin){
            return LocalTime.of(horas, pasoMin);
        }

        // si llega hasta aqui es que minutos > pasoMin
        // deberia usar un while
        int pasoMinMultiplo=pasoMin;
        for (int i = 0; i < 59; i++) {
            if(pasoMin + minutos >= 60){
                if(horas == 23) {
                    horas = -1;
                }
                return LocalTime.of(horas+1, 0);
            }
            if(pasoMinMultiplo >= minutos){
                return LocalTime.of(horas, pasoMinMultiplo);
            }
            pasoMinMultiplo = pasoMin*i;
        }

        //if pasoMin + minutos >= 60 entonces hora ++ y minutos = (pasoMin + minutos) - 60

        throw new IllegalArgumentException("Algo hiciste mal");
    }
}
