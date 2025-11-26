package com.docencia.listas.ejercicio01;

import java.util.Collections;
import java.util.List;

public class Ejercicio01 {

    private Ejercicio01() {
        // Utilidad estática
    }

    public static int maximo(List<Integer> numeros) {

        if (numeros == null || numeros.isEmpty()) {
            return -1;
        }

        return Collections.max(numeros); //! Extremadamente útil

    }

    public static int minimo(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return -1;
        }

        return Collections.min(numeros);
    }

    public static void eliminarNegativos(List<Integer> numeros) {

        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) < 0){
                numeros.remove(numeros.get(i));
            }
        }
    }


}
