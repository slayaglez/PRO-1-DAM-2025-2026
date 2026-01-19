package com.docencia.interfaces.ejercicio8;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Notificable.
 */
public class SmsNotifier implements Notificable {

    private UUID id;
    private String numero;
    private String proveedor;

    public SmsNotifier(UUID id, String numero, String proveedor) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getNumero() { return numero; }
    public String getProveedor() { return proveedor; }

    @Override
    public boolean notificar(String mensaje) {
        return mensaje != null && !mensaje.isBlank() && numero != null && numero.length() >= 6;
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
