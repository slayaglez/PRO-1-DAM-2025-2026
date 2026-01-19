package com.docencia.interfaces.ejercicio7;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Exportable.
 */
public class CsvExporter implements Exportable {

    private UUID id;
    private String separador;
    private int columnas;

    public CsvExporter(UUID id, String separador, int columnas) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getSeparador() { return separador; }
    public int getColumnas() { return columnas; }

    @Override
    public String exportar() {
        return "CSV(" + columnas + ")";
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
