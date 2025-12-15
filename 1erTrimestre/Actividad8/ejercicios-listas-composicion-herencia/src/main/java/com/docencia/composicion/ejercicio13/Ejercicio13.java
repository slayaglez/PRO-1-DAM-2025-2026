package com.docencia.composicion.ejercicio13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con clases de libros y listas de libros
 * pudiendo buscar libros por autor, agregar y eliminar.
 */
public class Ejercicio13 {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El tulipan", "Federico", 2004);
        Libro libro2 = new Libro("La tortuga", "Federico", 2006);
        Libro libro3 = new Libro("La cocina", "Sergio", 2008);
        Libro libro4 = new Libro("Perdí la cordura", "Sebastian", 2025);

        List<Libro> libros = new ArrayList<>();
        libros.add(libro3);
        libros.add(libro2);
        libros.add(libro1);
        //System.out.println(libros);

        Biblioteca librosDeBiblio = new Biblioteca(libros);
        librosDeBiblio.agregarLibro(libro4);
        System.out.println(librosDeBiblio);

        System.out.println("\n");
        System.out.println(librosDeBiblio.buscarPorAutor("Federico"));

        librosDeBiblio.eliminarLibroPorTitulo("El tulipan");
        
        System.out.println("\n");
        System.out.println(librosDeBiblio.buscarPorAutor("Federico"));
    }

    

    
}
