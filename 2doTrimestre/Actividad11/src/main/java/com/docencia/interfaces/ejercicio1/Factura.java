package com.docencia.interfaces.ejercicio1;

import java.util.UUID;

/**
 * Implementacion concreta de Pagable.
 */
public class Factura implements Pagable {

    private UUID id;
    private double base;
    private double iva;

    public Factura(UUID id, double base, double iva) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.base = base;
        this.iva = iva;
    }

    public UUID getId() {
        return id;
    }

    public double getBase() {
        return base;
    }

    public double getIva() {
        return iva;
    }

    @Override
    public double total() {
        return base + (base * iva);
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
        Factura other = (Factura) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Factura [id=" + id + ", base=" + base + ", iva=" + iva + "]";
    }

    
}
