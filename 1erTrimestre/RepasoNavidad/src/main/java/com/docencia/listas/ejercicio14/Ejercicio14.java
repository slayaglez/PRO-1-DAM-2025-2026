package com.docencia.listas.ejercicio14;


import java.util.ArrayList;
import java.util.List;


/**
 * Ejercicio 14
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio14 {

    private Ejercicio14() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


    public static List<String> eliminarDuplicadosPreservandoOrden(List<String> textos) {

        if (textos == null || textos.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> resultado = new ArrayList<>(textos);

        
        for (int i = 0; i < textos.size(); i++) {
            String palabra = textos.get(i);
            //resultado.removeAll(palabra);  //! POR HACER NO TE OLVIDES          
        }
        
        return resultado;
    }

}
