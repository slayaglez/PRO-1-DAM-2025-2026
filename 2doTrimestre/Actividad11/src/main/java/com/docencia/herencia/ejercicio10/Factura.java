package com.docencia.herencia.ejercicio10;

import java.util.UUID;

public class Factura extends Documento {

    private String numero;

    public Factura(UUID id, String titulo, String numero) {
        super(id, titulo);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public String getNumero() { return numero; }

    @Override
    public String tipo() {
        return "Factura";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
