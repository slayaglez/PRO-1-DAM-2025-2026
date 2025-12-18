package com.docencia.listas.ejercicio1;

import java.util.List;

/**
 * EJERCICIO 1 (ESQUELETO) - Contar mayores que un umbral.
 */
public class Ejercicio1 {

    private Ejercicio1() {
    }


    public static int contarMayoresQue(List<Integer> numeros, int umbral) {
        if(numeros == null || numeros.isEmpty()){
            return 0;
        }

        int total=0;

        for (int i = 0; i < numeros.size(); i++) {
            
            if(numeros.get(i)!=null && numeros.get(i) > umbral){
                total++;
            }
        }
        return total;
    }
}
