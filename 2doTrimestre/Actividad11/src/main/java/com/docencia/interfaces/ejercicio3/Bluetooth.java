package com.docencia.interfaces.ejercicio3;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Conectable.
 */
public class Bluetooth implements Conectable {

    private UUID id;
    private String mac;
    private int canal;

    public Bluetooth(UUID id, String mac, int canal) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getMac() { return mac; }
    public int getCanal() { return canal; }

    @Override
    public boolean conectar(String destino) {
        return destino != null && destino.contains(":");
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
