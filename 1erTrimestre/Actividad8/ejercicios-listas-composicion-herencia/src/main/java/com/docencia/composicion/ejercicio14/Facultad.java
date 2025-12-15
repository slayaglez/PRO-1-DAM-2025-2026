package com.docencia.composicion.ejercicio14;

import java.util.List;

public class Facultad {
    private List<Estudiante> facultad;

    public Facultad(List<Estudiante> facultad) {
        this.facultad = facultad;
    }

    public List<Estudiante> getFacultad() {
        return facultad;
    }

    public void setFacultad(List<Estudiante> facultad) {
        this.facultad = facultad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((facultad == null) ? 0 : facultad.hashCode());
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
        Facultad other = (Facultad) obj;
        if (facultad == null) {
            if (other.facultad != null)
                return false;
        } else if (!facultad.equals(other.facultad))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Facultad [facultad=" + facultad + "]";
    }

    /**
     * Metodo que agrega un Estudiante a Facultad
     * @param estudiante Estudiante que se desea agregar
     */
    public void agregarEstudiante(Estudiante estudiante) {
        facultad.add(estudiante);
    }

    
}
