package com.docencia.composicion.ejercicio20;

import java.util.Objects;

public class Mascota {

    private String especie;
    private String nombre;

    public Mascota() {
    }

    /**
     * Constructor por defecto
     * @param especie
     * @param nombre
     */
    public Mascota(String especie, String nombre) {
        this.especie = especie;
        this.nombre = nombre;
    }

    /**Getters y Setters */
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.especie);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mascota other = (Mascota) obj;
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("especie: ").append(especie).append("\n");
        sb.append("nombre: ").append(nombre);
        return sb.toString();
    }

    
    
}
