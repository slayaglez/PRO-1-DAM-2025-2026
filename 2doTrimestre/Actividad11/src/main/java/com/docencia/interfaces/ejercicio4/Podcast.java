/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio4;

import java.util.UUID;

/**
 * Implementacion concreta de Reproducible.
 */
public class Podcast implements Reproducible {

    private UUID id;
    private String nombre;
    private int episodio;

    public Podcast(UUID id, String nombre, int episodio) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.episodio = episodio;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEpisodio() {
        return episodio;
    }

    @Override
    public String reproducir() {
        return "Reproduciendo podcast: " + nombre + " #" + episodio;
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
        Podcast other = (Podcast) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Podcast [id=" + id + ", nombre=" + nombre + ", episodio=" + episodio + "]";
    }

    
}
