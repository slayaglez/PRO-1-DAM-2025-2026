package com.docencia.listas.ejercicio07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio07 {

    private Ejercicio07() {
    }

    public static void ordenarConSort(List<Integer> lista) {
        Collections.sort(lista);
    }

    public static void ordenarSinSort(List<Integer> lista) { 
        
        List<Integer> resultado = new ArrayList<>();

        int tamanio= lista.size();
        for (int i = 0; i < tamanio; i++) {
            resultado.add(Collections.min(lista));
            lista.removeIf(elemento -> elemento.equals((Collections.min(lista)))); 
        }
        lista.addAll(resultado);
    }
}
