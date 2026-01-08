package com.docencia.listas.ejercicio6;


import java.util.List;


/**
 * Ejercicio 6
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio6 {

    private Ejercicio6() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


/**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static int contarOcurrencias(List<String> textos, String objetivo) {
        // Implementación provisional: siempre 0.

        if(textos != null && objetivo != null && !textos.isEmpty() && !objetivo.isBlank()){
            int resultado = 0;
            for (int i = 0; i < textos.size(); i++) {
                
                String palabra = textos.get(i);
                if(palabra != null){
                    palabra = palabra.trim().toLowerCase();
                    if(palabra.equals(objetivo.trim().toLowerCase())){
                        resultado++;
                    }
                }
            }
            return resultado;
        }
        return 0;
    }

}
