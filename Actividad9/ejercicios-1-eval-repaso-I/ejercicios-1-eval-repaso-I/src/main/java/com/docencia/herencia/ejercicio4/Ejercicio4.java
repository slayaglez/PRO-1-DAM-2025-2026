package com.docencia.herencia.ejercicio4;

import java.util.List;

/**
 * HERENCIA – Ejercicio 4: Publicaciones recientes.
 *
 * Implementa la lógica de "reciente" y cuenta publicaciones recientes.
 * Esta clase incluye un main opcional para pruebas manuales.
 */
public class Ejercicio4 {

    private Ejercicio4() {
    }

    public static void main(String[] args) {
        Publicacion p1 = new LibroPublicacion("Libro reciente", 2021);
        Publicacion p2 = new ArticuloPublicacion("Artículo muy reciente", 2023);

        int recientes = contarRecientes(List.of(p1, p2), 2024);
        System.out.println("Recientes = " + recientes);
    }

    public static int contarRecientes(List<Publicacion> publicaciones, int anioActual) {
        // TODO: contar publicaciones recientes ignorando null.
        return 0;
    }
}
