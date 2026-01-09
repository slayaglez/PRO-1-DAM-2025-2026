/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clases con herencias que trabajan con cartas, destinatarios y numeros de paginas
 */
package com.docencia.herencia.ejercicio14;

public abstract class Documento {
    public final String titulo;

    /**
     * Constructor por defecto
     * @param titulo titulo del documento
     */
    protected Documento(String titulo) {
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException();
        }
        this.titulo = titulo.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract String descripcion();
}
