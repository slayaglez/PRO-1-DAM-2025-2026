package com.docencia.herencia.ejercicio8;

import java.util.UUID;

public class PagoTarjeta extends Pago {

    private String ultimos4;

    public PagoTarjeta(UUID id, double importe, String ultimos4) {
        super(id, importe);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public String getUltimos4() { return ultimos4; }

    @Override
    public boolean requiereValidacion() {
        return true;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
