package com.docencia.app;

import java.util.Objects;

public class Direccion {

    private String calle;
    private int cp;
    private String localidad;
    private int numero;

    public Direccion() {
    }

    public Direccion(String calle, int cp, String localidad, int numero) {
        this.calle = calle;
        this.cp = cp;
        this.localidad = localidad;
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, cp, localidad, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Direccion other = (Direccion) obj;
        return Objects.equals(calle, other.calle) && cp == other.cp && Objects.equals(localidad, other.localidad)
                && numero == other.numero;
    }

    /** Getters y setters */
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    

    @Override
    public String toString() {
        return "{" +
            " calle='" + getCalle() + "'" +
            ", cp='" + getCp() + "'" +
            ", localidad='" + getLocalidad() + "'" +
            ", numero='" + getNumero() + "'" +
            "}";
    }

}
