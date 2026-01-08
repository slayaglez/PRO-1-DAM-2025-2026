package com.docencia.listas.ejercicio9;


import java.util.List;


/**
 * Ejercicio 9
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio9 {

    private Ejercicio9() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }



    public static int sumarPositivos(List<Integer> numeros) {
        // Implementación provisional: siempre 0.
        int suma = 0;
        if(numeros != null && !numeros.isEmpty()){
            for (int i = 0; i < numeros.size(); i++) {
                if(numeros.get(i) != null && numeros.get(i)>0){
                    suma += numeros.get(i);
                }
            }
        }
        return suma;
    }

}
