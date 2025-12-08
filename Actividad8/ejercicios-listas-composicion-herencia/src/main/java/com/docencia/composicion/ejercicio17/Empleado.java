package com.docencia.composicion.ejercicio17;

import java.util.List;

public class Empleado {
    private String nombre;
    private double salario;
    private List<Proyecto> proyectos;

    /**
     * Constructor por defecto
     * @param nombre nombre del empleado
     * @param salario salario del empleado (double)
     * @param proyectos lista de proyectos que lleva
     */
    public Empleado(String nombre, double salario, List<Proyecto> proyectos) {
        this.nombre = nombre;
        this.salario = salario;
        this.proyectos = proyectos;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public List<Proyecto> getProyectos() {
        return proyectos;
    }
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(salario);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((proyectos == null) ? 0 : proyectos.hashCode());
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
        Empleado other = (Empleado) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
            return false;
        if (proyectos == null) {
            if (other.proyectos != null)
                return false;
        } else if (!proyectos.equals(other.proyectos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", salario=" + salario + ", proyectos=" + proyectos + "]";
    }

    
}
