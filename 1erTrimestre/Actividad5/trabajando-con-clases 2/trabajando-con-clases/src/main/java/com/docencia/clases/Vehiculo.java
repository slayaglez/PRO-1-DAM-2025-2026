package com.docencia.clases;
import java.util.Objects;

public abstract class Vehiculo implements IVehiculo{
    private String matricula;
    private String modelo;
    private String marca;
    private final String licencia;

    public abstract String suSonido();

    /** 
     * Constructor vacío
     */
    public Vehiculo(){
        this.licencia = "";
    }
    
    public Vehiculo(String licencia, String matricula) {
        this.matricula = matricula;
        this.licencia = licencia;

    }

    public Vehiculo(String licencia, String matricula, String modelo, String marca) {
        this.licencia = licencia;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }


    /**Getters y Setters */
    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }


    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", marca='" + getMarca() + "'" +
            "}";
    }

    @Override
    public int numeroRuedas(){
        return 0;
    }

    @Override
    public int numeroPuertas(){
        return 0;
    }

    @Override
    public String sonido(){
        return "";
    }

    public static void main(String[] args) {
        
    }
}
