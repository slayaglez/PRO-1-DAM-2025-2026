/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase cliente que trabaja con clientes
 */
package com.docencia.clases.ejercicio5;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre;
    private boolean vip;

    /**
     * Constructor vacio
     */
    public Cliente() {}

    /**
     * Constructor con identificador unico
     * @param id identificador unico
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Constructor por defecto
     * @param id identificador unico
     * @param nombre nombre del cliente
     * @param vip si el cliente es vip o no
     */
    public Cliente(int id, String nombre, boolean vip) {
        this.id = id;
        this.nombre = nombre;
        this.vip = vip;
    }

    /** Getters y Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", vip=" + vip + "]";
    }

    
}
