package com.docencia.herencia.ejercicio8;

import java.util.UUID;

public class PagoEfectivo extends Pago {

    private boolean entregado;

    public PagoEfectivo(UUID id, double importe, boolean entregado) {
        super(id, importe);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public Boolean getEntregado() { return entregado; }

    @Override
    public boolean requiereValidacion() {
        return false;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
