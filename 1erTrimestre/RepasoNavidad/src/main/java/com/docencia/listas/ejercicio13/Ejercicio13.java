package com.docencia.listas.ejercicio13;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Ejercicio 13
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio13 {

    private Ejercicio13() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


    public static List<Integer> filtrarMayoresYOrdenar(List<Integer> numeros, int minimo) {

        if(minimo <= 0) {
            return new ArrayList<>();
        }
        List<Integer> resultado = new ArrayList<>(numeros);
        resultado.removeIf(numero -> numero == null);
        resultado.removeIf(numero -> numero < minimo);
        resultado.sort(Comparator.naturalOrder());
        return resultado;
    }

}
