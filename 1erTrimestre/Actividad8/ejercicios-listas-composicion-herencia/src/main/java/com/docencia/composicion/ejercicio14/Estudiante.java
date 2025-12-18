package com.docencia.composicion.ejercicio14;

public class Estudiante {
    private String id;
    private String nombre;

    public Estudiante(){}
    
    /**
     * Constructor por defecto
     * @param id id del estudiante (alfanumerico)
     * @param nombre nombre del estudiante
     */
    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Estudiante getAlumno(){
        Estudiante alumno = new Estudiante(id, nombre);
        return alumno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        Estudiante other = (Estudiante) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
    
}
