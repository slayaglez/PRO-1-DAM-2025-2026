/**
 * Clase Persona que almacena la información de esta
 * 
 * @author slayaglez
 * @version 1.0.0
 * @date 20 Oct 2025
 */

public class Persona {

    private String fechaNacimiento;
    private String nombre;
    private String apellido1;
    private String apellido2;

    /**
     * Constructor vacío //! Importante
     */
    public Persona() {
    }

    /**
     * Constructor de la clase persona
     * @param nombre Parámetro del nombre para la clase
     */
    public Persona(String nombre) {
        this.nombre = nombre;
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

    
}

