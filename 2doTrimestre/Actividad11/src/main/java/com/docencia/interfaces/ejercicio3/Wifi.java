package com.docencia.interfaces.ejercicio3;

import java.util.UUID;

/**
 * Implementacion concreta de Conectable.
 */
public class Wifi implements Conectable {

    private UUID id;
    private String ssid;
    private String password;

    public Wifi(UUID id, String ssid, String password) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.ssid = ssid;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getSsid() {
        return ssid;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean conectar(String destino) {
        return destino != null && !destino.isBlank();
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
        Wifi other = (Wifi) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Wifi [id=" + id + ", ssid=" + ssid + ", password=" + password + "]";
    }

}
