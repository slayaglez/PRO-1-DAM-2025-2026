package com.docencia.listas.ejercicio1;

import java.util.List;

/**
 * Ejercicio 1
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio1 {

    private Ejercicio1() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }

    /**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static int contarMayoresQue(List<Integer> numeros, int umbral) {
        if (numeros != null) {
            int mayores = 0;
            for (int i = 0; i < numeros.size(); i++) {
                if (numeros.get(i) != null && numeros.get(i) > umbral) {
                    mayores++;
                }
            }
            return mayores;
        }
        return 0;

    }

}
