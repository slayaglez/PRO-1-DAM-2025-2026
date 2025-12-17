/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Libros
 */
package com.docencia.clases.ejercicio2;

import java.util.Objects;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;

    /**
     * Constructor vacío
     */
    public Libro() {}

    /**
     * Constructor por id
     * @param isbn identificador unico
     */
    public Libro(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Constructor por defecto
     * @param isbn identificador unico
     * @param titulo titulo del libro
     * @param autor autor del libro
     */
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    /** Getters y Setters */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        return Objects.equals(isbn, other.isbn);
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + "]";
    }

    
}
