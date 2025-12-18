package com.docencia.composicion.ejercicio13;
import java.util.ArrayList;
import java.util.List;
/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase biblioteca que construye con una lista de Libro, tambien tiene metodos
 * como agregar un libro, eliminarlo por su titulo o buscar uno por autor.
 */
public class Biblioteca {
    private List<Libro> libros;

    /**
     * Constructor por defecto
     * @param libros Lista de libros
     */
    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((libros == null) ? 0 : libros.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Biblioteca other = (Biblioteca) obj;
        if (libros == null) {
            if (other.libros != null)
                return false;
        } else if (!libros.equals(other.libros))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Biblioteca [libros=" + libros + "]";
    }

    /**
     * Metodo que agrega un libro a una lista de tipo Biblioteca
     * @param libro libro a añadir
     * @return true || false
     */
    public boolean agregarLibro(Libro libro){
        
        if(libro != null){
            libros.add(libro);
            return true;
        }
        
        return false;
    }

    /**
     * Metodo que busca un libro en una lista de la clase Biblioteca por autor
     * @param autor autor cuyo libro se busca
     * @return Una lista de libros
     */
    public List<Libro> buscarPorAutor(String autor){

        if(autor == null || autor.isBlank()){
            return null;
        }

        List<Libro> librosPorAutor = new ArrayList<>();

        for (int i = 0; i < libros.size(); i++) {
            Libro libroParticular = libros.get(i);
            String autorBuscado = libroParticular.getAutor();
            if(autor.equals(autorBuscado)){
                librosPorAutor.add(libroParticular);
            }
        }
        return librosPorAutor;
    }

    /**
     * Metodo que elimina un libro por su titulo
     * @param titulo titulo del libro que se desea borrar
     * @return true || false
     */
    public boolean eliminarLibroPorTitulo(String titulo){

        if(titulo == null || titulo.isBlank()){
            return false;
        }

        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getTitulo().equals(titulo)){
                libros.remove(i);
            }
        }
        return true;
    }
}
