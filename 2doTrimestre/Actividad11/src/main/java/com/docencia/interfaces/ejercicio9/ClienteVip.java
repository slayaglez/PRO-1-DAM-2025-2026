package com.docencia.interfaces.ejercicio9;

import java.util.UUID;

/**
 * Implementacion concreta de Descontable.
 */
public class ClienteVip implements Descontable {

    private UUID id;
    private double porcentaje;
    private String nivel;

    public ClienteVip(UUID id, double porcentaje, String nivel) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.porcentaje = porcentaje;
        this.nivel = nivel;
    }

    public UUID getId() {
        return id;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public String getNivel() {
        return nivel;
    }

    @Override
    public double aplicarDescuento(double precio) {
        return precio - (precio * porcentaje);
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
        ClienteVip other = (ClienteVip) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClienteVip [id=" + id + ", porcentaje=" + porcentaje + ", nivel=" + nivel + "]";
    }

    
}
