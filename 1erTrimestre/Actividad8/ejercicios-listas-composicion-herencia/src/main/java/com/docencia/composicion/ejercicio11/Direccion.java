package com.docencia.composicion.ejercicio11;

import java.util.Objects;

public class Direccion extends Persona{
    private String pais;
    private String ciudad;
    private String calle;
    private int cp;
    
    public Direccion() {}

    public Direccion(String pais, String ciudad, String calle, int cp) {
        super();
        this.pais = pais;
        this.ciudad = ciudad;
        this.calle = calle;
        this.cp = cp;
    }


    /** Getters y setters*/
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

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

    

    @Override
    public int hashCode() {
        return Objects.hash(pais, ciudad, calle, cp);
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
        return Objects.equals(pais, other.pais) && Objects.equals(ciudad, other.ciudad)
                && Objects.equals(calle, other.calle) && cp == other.cp;
    }

    @Override
    public String toString() {
        return "Direccion: " + pais + ", " + ciudad + ", calle " + calle + ", código postal: " + cp ;
    }

    
}
