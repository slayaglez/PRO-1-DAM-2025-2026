package com.docencia.interfaces.ejercicio6;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Autenticable.
 */
public class Usuario implements Autenticable {

    private UUID id;
    private String nombre;
    private String hash;

    public Usuario(UUID id, String nombre, String hash) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public String getHash() { return hash; }

    @Override
    public boolean autenticar(String clave) {
        return clave != null && clave.equals(hash);
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
