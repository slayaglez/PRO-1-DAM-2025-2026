package com.docencia.listas.ejercicio11;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Ejercicio 11
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio11 {

    private Ejercicio11() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


    public static List<Integer> ordenarDescSinNulls(List<Integer> numeros) {
        if (numeros == null) {
            return new ArrayList<>();
        }
        List<Integer> copia = new ArrayList<>(numeros);
        copia.removeIf(numero -> numero == null);
        copia.sort(Comparator.reverseOrder());
        return copia;
    }

}
