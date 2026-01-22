/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio6;

import java.util.UUID;

/**
 * Implementacion concreta de Autenticable.
 */
public class Admin implements Autenticable {

    private UUID id;
    private String nombre;
    private String hash;

    public Admin(UUID id, String nombre, String hash) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.hash = hash;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public boolean autenticar(String clave) {
        return clave != null && clave.equals(hash);
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
        Admin other = (Admin) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", nombre=" + nombre + ", hash=" + hash + "]";
    }

    
}
