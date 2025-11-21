package com.docencia.ejercicio.clases.cuatro;
/**
 * @author slayaglez
 * @brief Clase coche que contiene constructores, getters y setters de los parametros
 * matrícula, marca, modelo y año y trabaja con ellos.
 * @date 24 Oct 2025
 * @version 1.0.0
 */
import java.util.Objects;
import java.time.Year;

public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private int anio;

    /**
     * Constructor vacío
     */
    public Coche() { }

    /**
     * Constructor solo matricula
     * @param matricula identificador
     */
    public Coche(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Constructor con todos los parámetros
     * @param matricula identificador
     * @param marca marca del coche
     * @param modelo modelo del coche
     * @param anio año de fabricación
     */
    public Coche(String matricula, String marca, String modelo, int anio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }


    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coche)) {
            return false;
        }
        Coche coche = (Coche) o;
        return Objects.equals(matricula.toUpperCase(), coche.matricula.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula.toUpperCase());
    }
    
    @Override
    public String toString() {
        String marca1;
        String modelo1;
        String matricula1;
        if(getMarca() == null){
            marca1 = "(Marca desconocida)";
        } else {
            marca1 = getMarca();
        }

        if(getModelo() == null){
            modelo1 = "(Modelo desconocida)";
        } else {
            modelo1 = getModelo();
        }

        
        if(getMatricula() == null){
            matricula1 = "sin matrícula";
        } else {
            matricula1 = getMatricula();
        }
        
        if(getAnio() == 0){
            return marca1+ " " + modelo1 + " (" + "(Año desconocido)" + ") - " + matricula1;
        } else {
            return marca1+ " " + modelo1 + " (" + getAnio() + ") - " + matricula1;
        }
          
    }


    
}

