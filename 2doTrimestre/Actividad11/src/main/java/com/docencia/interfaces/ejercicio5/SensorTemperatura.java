/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio5;

import java.util.UUID;

/**
 * Implementacion concreta de Medible.
 */
public class SensorTemperatura implements Medible {

    private UUID id;
    private String ubicacion;
    private double celsius;

    public SensorTemperatura(UUID id, String ubicacion, double celsius) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.ubicacion = ubicacion;
        this.celsius = celsius;
    }

    public UUID getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getCelsius() {
        return celsius;
    }

    @Override
    public double medir() {
        return celsius;
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
        SensorTemperatura other = (SensorTemperatura) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SensorTemperatura [id=" + id + ", ubicacion=" + ubicacion + ", celsius=" + celsius + "]";
    }

    
}
