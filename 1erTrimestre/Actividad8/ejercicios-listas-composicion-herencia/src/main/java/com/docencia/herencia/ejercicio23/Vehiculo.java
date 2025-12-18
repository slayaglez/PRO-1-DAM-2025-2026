package com.docencia.herencia.ejercicio23;
import java.util.Objects;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private String matricula;


    public Vehiculo() {
    }

    public Vehiculo(String matricula){
        this.matricula = matricula;
    }

    public Vehiculo (String matricula, String marca){
        this.matricula = matricula;
        this.marca = marca;
    }

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
            " marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", matricula='" + getMatricula() + "'" +
            "}";
    }

    abstract String descripcion();
    

}
