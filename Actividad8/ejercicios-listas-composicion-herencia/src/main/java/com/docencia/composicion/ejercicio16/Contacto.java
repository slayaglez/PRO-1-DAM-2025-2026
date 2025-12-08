package com.docencia.composicion.ejercicio16;

import java.util.List;

public class Contacto {
    private String nombre;
    private List<Telefono> telefonos;

    public Contacto(){}

    public Contacto(String nombre){
        this.nombre = nombre;
    }

    public Contacto(List<Telefono> telefonos){
        this.telefonos = telefonos;
    }

    public Contacto(String nombre, List<Telefono> telefonos) {
        this.nombre = nombre;
        this.telefonos = telefonos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((telefonos == null) ? 0 : telefonos.hashCode());
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
        Contacto other = (Contacto) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (telefonos == null) {
            if (other.telefonos != null)
                return false;
        } else if (!telefonos.equals(other.telefonos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contacto [nombre=" + nombre + ", telefonos=" + telefonos + "]";
    }

    public void agregarTelefono(Telefono telefono){
        telefonos.add(telefono);
    }

    
}
