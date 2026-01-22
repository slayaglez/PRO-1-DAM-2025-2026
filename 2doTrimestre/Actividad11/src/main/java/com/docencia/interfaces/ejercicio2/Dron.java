/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio2;

import java.util.UUID;

/**
 * Implementacion concreta de Volador.
 */
public class Dron implements Volador {

    private UUID id;
    private String marca;
    private int bateriaMinutos;

    public Dron(UUID id, String marca, int bateriaMinutos) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.marca = marca;
        this.bateriaMinutos = bateriaMinutos;
    }

    public UUID getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public int getBateriaMinutos() {
        return bateriaMinutos;
    }

    @Override
    public int altitudMaxima() {
        return 500;
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
        Dron other = (Dron) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Dron [id=" + id + ", marca=" + marca + ", bateriaMinutos=" + bateriaMinutos + "]";
    }

    
}
