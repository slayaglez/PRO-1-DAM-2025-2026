package com.docencia.interfaces.ejercicio3;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Conectable.
 */
public class Wifi implements Conectable {

    private UUID id;
    private String ssid;
    private String password;

    public Wifi(UUID id, String ssid, String password) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getSsid() { return ssid; }
    public String getPassword() { return password; }

    @Override
    public boolean conectar(String destino) {
        return destino != null && !destino.isBlank();
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
