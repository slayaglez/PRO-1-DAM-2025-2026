package org.docencia.unidad3.examen.ejercicio01;
/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con el nombre y la nota de un alumno
 */
import java.util.Objects;

public class Alumno {

    private String nombre;
    private int nota;
    
    /** 
     * Constructor vacio
     */
    public Alumno() {
    }

    /**
     * Constructor por defecto
     * @param nombre nombre del alumno
     * @param nota la nota que haya sacado
     */
    public Alumno(String nombre, int nota) {
        if(nota > 10 || nota < 0){
            throw new IllegalArgumentException();
        }
        this.nombre=nombre;
        this.nota=nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }


    public void setNota(int nota) {
        if(nota > 10 || nota < 0){
            throw new IllegalArgumentException();
        }
        this.nota = nota;
    }


    /**
     * Funcion que que devuelve un mensaje en base a la nota sacada
     * @return mensaje en base a la nota
     */
    public String getCalificacionTexto() {
        if(nota >= 0 && nota < 5){
            return "Insuficiente";
        }
        if(nota >= 5 && nota < 6){
            return "Suficiente";
        }
        if(nota >= 6 && nota < 7){
            return "Bien";
        }
        if(nota >= 7 && nota < 9){
            return "Notable";
        }
        if(nota >= 9 && nota <= 10){
            return "Sobresaliente";
        }
        return null;
    }

    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && nota == alumno.nota;
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", nota='" + getNota() + "'" +
            getCalificacionTexto() +
            "}";
    }

}
