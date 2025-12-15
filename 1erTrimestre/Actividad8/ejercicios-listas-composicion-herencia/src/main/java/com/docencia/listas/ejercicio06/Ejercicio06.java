package com.docencia.listas.ejercicio06;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio06 {

    private Ejercicio06() {
    }

    public static List<Integer> filtrarMayoresQue(List<Integer> lista, int limite) {

        List<Integer> resultado = new ArrayList<>();
        
        
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i) >= limite){
                resultado.add(lista.get(i));
            } 
        }
        return resultado;
    }
}
