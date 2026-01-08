package com.docencia.listas.ejercicio5;


import java.util.ArrayList;
import java.util.List;


/**
 * Ejercicio 5
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio5 {

    private Ejercicio5() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }

    public static List<String> normalizarNombres(List<String> nombres) {
 
        if (nombres != null && !nombres.isEmpty()) {
            String resultado = "";
            List<String> resultadoLista = new ArrayList<>();
            for (int i = 0; i < nombres.size(); i++) {
                if(nombres.get(i) != null && !nombres.get(i).isBlank()){
                    String nombre = nombres.get(i);
                    resultado = nombre.trim().toLowerCase();
                    char inicial = resultado.charAt(0);
                    String inicialString = String.valueOf(inicial);
                    String inicialStringUpper = inicialString.toUpperCase();
                    resultadoLista.add(resultado.replaceFirst(inicialString, inicialStringUpper));
                }
            }
            return resultadoLista;
        }
        return new ArrayList<>();
    }

}
