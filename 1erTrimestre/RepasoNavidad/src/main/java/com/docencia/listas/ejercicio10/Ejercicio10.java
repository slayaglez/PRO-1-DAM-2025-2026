package com.docencia.listas.ejercicio10;


import java.util.ArrayList;
import java.util.List;


/**
 * Ejercicio 10
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio10 {

    private Ejercicio10() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }



    public static List<String> filtrarPorPrefijo(List<String> textos, String prefijo) {
        // Implementación provisional: lista vacía.
        List<String> resultado = new ArrayList<>();
        if(textos != null && !textos.isEmpty() && prefijo != null && !prefijo.isBlank()){
            prefijo = prefijo.trim();
            for (int i = 0; i < textos.size(); i++) {
                if(textos.get(i) != null && !textos.get(i).isBlank()){
                    String palabra = textos.get(i);
                    if (palabra.trim().toLowerCase().contains(prefijo)) {
                        resultado.add(palabra.trim());
                    }
                }
            }
        }
        return resultado;
    }

}
