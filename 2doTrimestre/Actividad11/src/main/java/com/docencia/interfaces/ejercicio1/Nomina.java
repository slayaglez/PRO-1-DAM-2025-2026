package com.docencia.interfaces.ejercicio1;

import java.util.UUID;

/**
 * Implementacion concreta de Pagable.
 */
public class Nomina implements Pagable {

    private UUID id;
    private double bruto;
    private double retencion;

    public Nomina(UUID id, double bruto, double retencion) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.bruto = bruto;
        this.retencion = retencion;
    }

    public UUID getId() {
        return id;
    }

    public double getBruto() {
        return bruto;
    }

    public double getRetencion() {
        return retencion;
    }

    @Override
    public double total() {
        return bruto - (bruto * retencion);
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
        Nomina other = (Nomina) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nomina{");
        sb.append("id=").append(id);
        sb.append(", bruto=").append(bruto);
        sb.append(", retencion=").append(retencion);
        sb.append('}');
        return sb.toString();
    }

}
