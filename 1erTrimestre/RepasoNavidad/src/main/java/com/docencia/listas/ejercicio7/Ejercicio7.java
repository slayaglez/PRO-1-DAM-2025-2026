package com.docencia.listas.ejercicio7;


import java.util.List;


/**
 * Ejercicio 7
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio7 {

    private Ejercicio7() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


/**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static String concatenarConSeparador(List<String> partes, String separador) {
        // Implementación provisional: cadena vacía.
        if(partes != null && !partes.isEmpty()){
            String resultado = "";
            if(partes.get(0) != null && !partes.get(0).isBlank()){
                resultado = partes.get(0);
            }
            
            for (int i = 1; i < partes.size(); i++) {
                if(partes.get(i) != null && !partes.get(i).isBlank()){
                    if(separador != null && !separador.isBlank()){
                        resultado += separador+partes.get(i);
                    } else {
                        resultado += ", "+partes.get(i);
                    }
                    
                }
            }
            return resultado;
        }
        return "";
    }

}
