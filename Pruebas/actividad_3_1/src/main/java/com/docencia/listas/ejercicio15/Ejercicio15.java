/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con listas
 */
package com.docencia.listas.ejercicio15;

import java.util.List;

/**
 * Ejercicio 15
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio15 {

    private Ejercicio15() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }

    /**
     * Busca un string de una lista por un fragmento que contenga
     * @param textos Lista de string
     * @param fragmento string que se busca
     */
    public static String buscarPrimeraQueContiene(List<String> textos, String fragmento) {
        if (fragmento == null || fragmento.isBlank()) {
            return null;
        }

        for (int i = 0; i < textos.size(); i++) {
            if (textos.get(i) != null) {
                String frase = textos.get(i);
                String fraseInsensitive = frase.toLowerCase();
                if (fraseInsensitive.contains(fragmento.toLowerCase().trim())) {
                    return frase.trim();
                }
            }

        }
        return null;
    }

}
