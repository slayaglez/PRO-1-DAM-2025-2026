package com.docencia.listas.ejercicio8;


import java.util.Collections;
import java.util.List;


/**
 * Ejercicio 8
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio8 {

    private Ejercicio8() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


/**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static Integer maximoSeguro(List<Integer> numeros) {
        // Implementación provisional: siempre null.
        Integer resultado=0;
        for (int i = 0; i < numeros.size(); i++) {
            if(numeros.get(i) == null){
                numeros.remove(i); //! POR TERMINAR
            }
        }
        resultado = Collections.max(numeros);
        
        return resultado;
    }

}
