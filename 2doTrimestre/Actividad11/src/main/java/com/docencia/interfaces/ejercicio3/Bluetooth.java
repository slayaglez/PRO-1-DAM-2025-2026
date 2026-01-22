/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio3;

import java.util.UUID;

/**
 * Implementacion concreta de Conectable.
 */
public class Bluetooth implements Conectable {

    private UUID id;
    private String mac;
    private int canal;

    public Bluetooth(UUID id, String mac, int canal) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.mac = mac;
        this.canal = canal;
    }

    public UUID getId() {
        return id;
    }

    public String getMac() {
        return mac;
    }

    public int getCanal() {
        return canal;
    }

    @Override
    public boolean conectar(String destino) {
        return destino != null && destino.contains(":");
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
        Bluetooth other = (Bluetooth) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bluetooth [id=" + id + ", mac=" + mac + ", canal=" + canal + "]";
    }

    
}
