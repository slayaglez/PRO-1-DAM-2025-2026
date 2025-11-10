package org.docencia.ejercicio.calificable;
/**
 * Clase Persona que trabaja con id, nombres y edades
 * @author slayaglez
 * @version 1.0.0
 */
import java.util.Objects;

public class Persona {
    private String id;
    private String nombre;
    private int edad;

    /**
     * Constructor vacio
     */
    public Persona() {
    }

    
    /**
     * Constructor por defecto
     * @param id identificador unico
     * @param nombre nombre de la persona
     * @param edad edad de la persona
     */
    public Persona(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public boolean equals(Object o) {
        
        if (o == this){
            return true;
        }
        if (!(o instanceof Persona)) {
            return false;
        }
        
        Persona persona = (Persona) o;
        
        if(id!=null){
            return Objects.equals(id, persona.id);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Persona{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            "}";
    }
    
}
