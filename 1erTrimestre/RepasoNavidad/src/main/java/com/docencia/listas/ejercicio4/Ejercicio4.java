package com.docencia.listas.ejercicio4;


import java.util.List;


/**
 * Ejercicio 4
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio4 {

    private Ejercicio4() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


/**
     * TODO: Implementar completamente según enunciado y tests.
     */
    public static double mediaValoresValidos(List<Integer> valores) {
        
        if(valores != null && !valores.isEmpty()){
            double media = 0;
            int tamanio = valores.size();
            if(valores.get(0) != null){
                media=valores.get(0);
            }

            for (int i = 1; i < valores.size(); i++) {
                if(valores.get(i)!= null){
                    media += valores.get(i);
                } else {
                    tamanio--;
                }
            }
            media /= tamanio;
            return media;
        }
        return 0;
    }

}
