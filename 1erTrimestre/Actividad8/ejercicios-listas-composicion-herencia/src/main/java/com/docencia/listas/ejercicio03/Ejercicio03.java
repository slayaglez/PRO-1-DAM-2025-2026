package com.docencia.listas.ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio03 {

    private Ejercicio03() {
    }

    public static List<Integer> sinDuplicados(List<Integer> original) {
        
        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : original) {
            if(!resultado.contains(numero)) {
                resultado.add(numero);
            }
        }
        return resultado;
    }
}
