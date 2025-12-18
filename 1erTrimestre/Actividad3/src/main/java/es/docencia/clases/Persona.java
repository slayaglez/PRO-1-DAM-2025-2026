package es.docencia.clases;
/**
 * Clase Persona que almacena la información de esta
 * 
 * @author slayaglez
 * @version 1.0.0
 * @date 20 Oct 2025
 */

public class Persona {

    private String identificador;
    private String fechaNacimiento;
    private String nombre;
    private String apellido1;
    private String apellido2;

    /**
     * Constructor vacío //! SUPER IMPORTANTE
     */
    public Persona() {
    }

    /**
     * Constructor de la clase persona
     * @param identificador Parámetro del id para la clase
     */
    public Persona(String identificador) {
        this.identificador = identificador;
    }


    /**
     * Constructor de la clase persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param nombre Mombre de la persona
    */
    public Persona(String fechaNacimiento, String nombre) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }


    //setter
    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    //getter
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    //setter
    public String getApellido1() {
        return this.apellido1;
    }

    //getter
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }


    //*toString
    @Override
    public String toString() {
        return "{" +
            " identificador='" + identificador + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            ", nombre='" + nombre + "'" +
            ", apellido1='" + getApellido1() + "'" +
            ", apellido2='" + apellido2 + "'" +
            "}";
    }
    
    //*toEquals;
    @Override
    public boolean equals(Object o){ //! SUPER SUPER IMPORTANTE
        if(this == o) {
            return true;
        }
        if(!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona)o;
        if(identificador != persona.getIdentificador()) {
            return false;
        }
        return true;
    }
    
}

