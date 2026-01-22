package com.docencia.interfaces.ejercicio7;

import java.util.UUID;

/**
 * Implementacion concreta de Exportable.
 */
public class JsonExporter implements Exportable {

    private UUID id;
    private boolean pretty;
    private int indent;

    public JsonExporter(UUID id, boolean pretty, int indent) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.pretty = pretty;
        this.indent = indent;
    }

    public UUID getId() {
        return id;
    }

    public boolean getPretty() {
        return pretty;
    }

    public int getIndent() {
        return indent;
    }

    @Override
    public String exportar() {
        return pretty ? "JSON(pretty)" : "JSON";
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
        JsonExporter other = (JsonExporter) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "JsonExporter [id=" + id + ", pretty=" + pretty + ", indent=" + indent + "]";
    }

    
}
