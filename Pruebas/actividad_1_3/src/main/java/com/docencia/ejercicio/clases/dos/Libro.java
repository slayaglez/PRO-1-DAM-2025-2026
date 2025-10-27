package com.docencia.ejercicio.clases.dos;
import java.util.Objects;
/**
 * @brief Clase libro que contiene constructores, getters y setters de los parámetros
 * titulo, autor y isbn y trabaja con ellos.
 * @author slayaglez
 * @date 24 Oct 2025
 * @version 1.0.0
 */
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    /**
     * Constructor vacío
     */
    public Libro() {}

    /**
     * Constructor usando los campos
     * @param titulo titulo del libro
     * @param autor quien escribió el libro
     * @param isbn identificador
     */
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) {
        this.isbn = isbn;

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(isbn.toUpperCase(), libro.isbn.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn.toUpperCase());
    }
    
    @Override
    public String toString() {
        return "'" + getTitulo() + "' de " + getAutor() + " (ISBN: "+ getIsbn()+ ")";
    }
}

