/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio8;

import java.util.UUID;

public class PagoEfectivo extends Pago {

    private boolean entregado;

    public PagoEfectivo(UUID id, double importe, boolean entregado) {
        super(id, importe);
        this.entregado = entregado;
}

    public Boolean getEntregado() { return entregado; }

    @Override
    public boolean requiereValidacion() {
        return false;
    }

    @Override
    public String toString() {
        return "PagoEfectivo [entregado=" + entregado + ", id=" + getId() + "]" + "importe=" + getImporte() + "entrega=";
    }

    
}
