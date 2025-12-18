package com.docencia.composicion.ejercicio14;

import java.util.List;

public class Universidad {
    private List<Facultad> universidad;

    public Universidad(List<Facultad> universidad) {
        this.universidad = universidad;
    }

    public List<Facultad> getUniversidad() {
        return universidad;
    }

    public void setUniversidad(List<Facultad> universidad) {
        this.universidad = universidad;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((universidad == null) ? 0 : universidad.hashCode());
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
        Universidad other = (Universidad) obj;
        if (universidad == null) {
            if (other.universidad != null)
                return false;
        } else if (!universidad.equals(other.universidad))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Universidad [universidad=" + universidad + "]";
    }


    
}
