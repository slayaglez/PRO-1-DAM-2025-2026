package com.docencia.listas.ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 3
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio3 {

    private Ejercicio3() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }

    /**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static List<Integer> interseccionOrdenada(List<Integer> a, List<Integer> b) {
        // Implementación provisional: siempre lista vacía.
        List<Integer> interseccion = new ArrayList<>();
        if (a != null && b != null) {
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < b.size(); j++) {
                    if (a.get(i) != null && b.get(j) != null && a.get(i).equals(b.get(j))
                            && !(interseccion.contains(a.get(i)))) {

                        interseccion.add(a.get(i));

                    }
                }
            }
        }

        return interseccion;
    }

}
