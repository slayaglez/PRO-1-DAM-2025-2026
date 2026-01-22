package com.docencia.interfaces.ejercicio8;

import java.util.UUID;

/**
 * Implementacion concreta de Notificable.
 */
public class EmailNotifier implements Notificable {

    private UUID id;
    private String from;
    private String to;

    public EmailNotifier(UUID id, String from, String to) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.from = from;
        this.to = to;
    }

    public UUID getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean notificar(String mensaje) {
        return mensaje != null && !mensaje.isBlank() && to.contains("@");
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
        EmailNotifier other = (EmailNotifier) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EmailNotifier [id=" + id + ", from=" + from + ", to=" + to + "]";
    }

    
}
