package com.docencia.interfaces.ejercicio7;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Exportable.
 */
public class JsonExporter implements Exportable {

    private UUID id;
    private boolean pretty;
    private int indent;

    public JsonExporter(UUID id, boolean pretty, int indent) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public boolean getPretty() { return pretty; }
    public int getIndent() { return indent; }

    @Override
    public String exportar() {
        return pretty ? "JSON(pretty)" : "JSON";
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
