package es.docencia.clases.ejercicio1;
import java.util.Objects;

public class Persona1 {

    private String nombre;
    private int edad;
    /**
     * Constructor vacío
     */
    public Persona1() {}

    /**
     * Constructor de la clase con propiedades
     * @param nombre Nombre de la persona
     * @param edad Edad de la persona
     */
    public Persona1(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //getter nombre
    public String getNombre() {
        return this.nombre;
    }

    //getter edad
    public int getEdad() {
        return this.edad;
    }

    //*toString
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            "}";
    }

    //*toEquals
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona1)) {
            return false;
        }
        Persona1 persona1 = (Persona1) o;
        return Objects.equals(nombre, persona1.nombre) && edad == persona1.edad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }
    
}
