package com.docencia.interfaces.ejercicio9;

import java.util.UUID;

/**
 * Implementacion concreta de Descontable.
 */
public class Cupon implements Descontable {

    private UUID id;
    private double importe;
    private String codigo;

    public Cupon(UUID id, double importe, String codigo) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.importe = importe;
        this.codigo = codigo;
    }

    public UUID getId() {
        return id;
    }

    public double getImporte() {
        return importe;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public double aplicarDescuento(double precio) {
        return Math.max(0.0, precio - importe);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cupon other = (Cupon) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cupon [id=" + id + ", importe=" + importe + ", codigo=" + codigo + "]";
    }

    
}
