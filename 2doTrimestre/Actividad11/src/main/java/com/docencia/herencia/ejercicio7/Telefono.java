package com.docencia.herencia.ejercicio7;

import java.util.UUID;

public class Telefono extends Dispositivo {

    private String numero;

    public Telefono(UUID id, String fabricante, String numero) {
        super(id, fabricante);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public String getNumero() { return numero; }

    @Override
    public String tipo() {
        return "Telefono";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
