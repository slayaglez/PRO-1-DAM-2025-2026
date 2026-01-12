package com.docencia.listas.ejercicio8;

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

    public static Integer maximoSeguro(List<Integer> numeros) {
        Integer resultado = 0;
        int cuentaNulls=0;
        if (numeros != null && !numeros.isEmpty()) {
            for (int i = 0; i < numeros.size(); i++) {
                if (numeros.get(i) != null && numeros.get(i) > resultado) {
                    resultado = numeros.get(i);
                }
                if(numeros.get(i)== null){
                    cuentaNulls++;
                }
                if (cuentaNulls == numeros.size()) {
                    return null;
                }
            }
            return resultado;
        }
        return null;
    }

}
