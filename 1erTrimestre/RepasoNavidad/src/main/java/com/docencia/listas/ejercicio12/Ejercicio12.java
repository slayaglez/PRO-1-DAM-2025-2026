package com.docencia.listas.ejercicio12;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Ejercicio 12
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio12 {

    private Ejercicio12() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }

    public static List<Integer> unionOrdenadaSinDuplicados(List<Integer> a, List<Integer> b) {
        List<Integer> union = new ArrayList<>();
        
        if(a!=null && !a.isEmpty()){
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i) != null && !union.contains(a.get(i))){
                    union.add(a.get(i));
                }
            }
        }
        if(b!=null && !b.isEmpty()){
            for (int i = 0; i < b.size(); i++) {
                if(b.get(i) != null && !union.contains(b.get(i))){
                    union.add(b.get(i));
                }
            }
        }
        union.sort(Comparator.naturalOrder());
        return union;
    }

}
