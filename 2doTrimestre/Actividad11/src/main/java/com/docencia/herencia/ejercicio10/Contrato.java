package com.docencia.herencia.ejercicio10;

import java.util.UUID;

public class Contrato extends Documento {

    private String partes;

    public Contrato(UUID id, String titulo, String partes) {
        super(id, titulo);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public String getPartes() { return partes; }

    @Override
    public String tipo() {
        return "Contrato";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
