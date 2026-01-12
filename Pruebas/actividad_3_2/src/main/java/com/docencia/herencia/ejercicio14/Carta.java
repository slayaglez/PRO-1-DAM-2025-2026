/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clases con herencias que trabajan con cartas, destinatarios y numeros de paginas
 */
package com.docencia.herencia.ejercicio14;

public class Carta extends Documento {
    /**
     * Constructor por defecto
     * @param titulo titulo del documento
     */
    public Carta(String titulo) {
        super(titulo);
    }

    private String destinatario;

    public void setDestinatario(String destinatario) {
        if(destinatario == null || destinatario.isBlank()){
            throw new IllegalArgumentException();
        }
        this.destinatario = destinatario.trim();
    }
    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public String descripcion() {
        return "Carta: " + getTitulo() + " | Para: "+destinatario;
    }
}
