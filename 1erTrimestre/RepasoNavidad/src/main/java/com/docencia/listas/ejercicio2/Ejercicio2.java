package com.docencia.listas.ejercicio2;


import java.util.ArrayList;
import java.util.List;


/**
 * Ejercicio 2
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio2 {

    private Ejercicio2() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


/**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static List<String> invertirYFiltrarNoVacias(List<String> cadenas) {
        List<String> resultado = new ArrayList<>();
        String palabra="";
        if (cadenas != null ) {
            for (int i = 0; i < cadenas.size(); i++) {
                if(cadenas.get(i)!=null && !(cadenas.get(i).isBlank())){
                    for (int j = cadenas.get(i).length()-1; j >= 0; j--) {
                        palabra += cadenas.get(i).charAt(j); 
                    }
                    
                    resultado.add(palabra);
                }
                palabra = "";
            }
        }
        // Implementación provisional: devuelve lista vacía.
        return resultado;
    }

}
