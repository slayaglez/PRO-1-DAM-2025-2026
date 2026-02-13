/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con instantes
 */
package com.docencia.fechas.ejercicio9;

import java.time.Instant;

public final class Ejercicio9 {

    private Ejercicio9() {}

    public static boolean canCancelWithin48h(Instant purchase, Instant now) {
        if(purchase == null || now == null){
            throw new NullPointerException();
        }

        return now.isBefore(purchase.plusSeconds(3600*48)) || now.equals(purchase.plusSeconds(3600*48));
    }
}
