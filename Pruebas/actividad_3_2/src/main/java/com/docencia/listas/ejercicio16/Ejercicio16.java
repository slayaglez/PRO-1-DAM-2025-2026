/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con listas y suma longitudes
 */
package com.docencia.listas.ejercicio16;


import java.util.List;


public class Ejercicio16 {

    private Ejercicio16() {
    }

    public static void main(String[] args) {
     
    }

    /**
     * Funcion que suma el tamanio de todas las cadenas en una lista.
     * @param textos la lista de cadenas
     * @return el tamanio total de las cadenas validas
     */
    public static int sumarLongitudesNoVacias(List<String> textos) {
        
        int tamanio=0;
        if(textos == null || textos.isEmpty()){
            return 0;
        }
        for (int i = 0; i < textos.size(); i++) {
            if(textos.get(i) != null && !textos.get(i).isBlank()){
                String palabra = textos.get(i);
                palabra = palabra.trim();
                tamanio += palabra.length();
            }
        }
        return tamanio;
    }

}
