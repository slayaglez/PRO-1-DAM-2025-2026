package com.docencia.interfaces.ejercicio5;

import java.util.UUID;

/**
 * Implementacion concreta de Medible.
 */
public class SensorPresion implements Medible {

    private UUID id;
    private String ubicacion;
    private double kpa;

    public SensorPresion(UUID id, String ubicacion, double kpa) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.ubicacion = ubicacion;
        this.kpa = kpa;
    }

    public UUID getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getKpa() {
        return kpa;
    }

    @Override
    public double medir() {
        return kpa;
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
        SensorPresion other = (SensorPresion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SensorPresion [id=" + id + ", ubicacion=" + ubicacion + ", kpa=" + kpa + "]";
    }

    
}
