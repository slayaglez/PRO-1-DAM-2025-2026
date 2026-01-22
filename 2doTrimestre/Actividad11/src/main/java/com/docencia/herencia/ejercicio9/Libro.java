/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio9;

import java.util.UUID;

public class Libro extends Producto {

    private String isbn;

    public Libro(UUID id, String nombre, double precio, String isbn) {
        super(id, nombre, precio);
        this.isbn = isbn;
}

    public String getIsbn() { return isbn; }

    @Override
    public String categoria() {
        return "Libro";
    }

    @Override
    public String toString() {
        return "Libro [isbn=" + isbn + ", id=" + getId() + "]";
    }

    
}
