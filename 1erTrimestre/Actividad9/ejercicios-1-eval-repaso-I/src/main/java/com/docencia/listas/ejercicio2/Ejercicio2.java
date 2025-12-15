package com.docencia.listas.ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 * EJERCICIO 2 (ESQUELETO) - Invertir y filtrar cadenas.
 */
public class Ejercicio2 {

    private Ejercicio2() {
    }

    /**
     * Funcion que invierte cada palabra de una lista y omite las vacias
     * @param cadenas lista de palabras
     * @return lista de palabras invertidas
     */
    public static List<String> invertirYFiltrarNoVacias(List<String> cadenas) {
        
        if (cadenas == null || cadenas.isEmpty()){
            return new ArrayList<>();
        }

        List<String> resultado = new ArrayList<>();
        char caracter = ' ';
        String palabra = "";
        
        for (int i = 0; i < cadenas.size(); i++) {                  // Recorro la lista
            String cadena = cadenas.get(i);
            if(cadena != null && !(cadena.isBlank())){              // Si la palabra es valida hago lo siguiente:
                for (int j = 0; j < cadena.length(); j++) {         // Recorro la palabra
                    caracter = cadena.charAt(cadena.length()-j-1);  // Invierto la palabra cogiendo los caracteres al reves
                    palabra += caracter;                            // Meto cada caracter en la palabra
                }
                resultado.add(palabra);                             // Sumo la palabra al resultado
                palabra="";                                         // Reinicio palabra
            } 
        }

        return resultado;
    }
}
