package com.docencia.composicion.ejercicio17;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados;

    public Empresa(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empleados == null) ? 0 : empleados.hashCode());
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
        Empresa other = (Empresa) obj;
        if (empleados == null) {
            if (other.empleados != null)
                return false;
        } else if (!empleados.equals(other.empleados))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [empleados=" + empleados + "]";
    }

    public double totalSalariosDeProyecto(Proyecto proyectoBuscado){

        //if empleado tiene proyecto cojo su salario
        double totalSalarios=0;
        for (Empleado empleado : empleados) { // itero los empleados
            for (Proyecto proyecto : empleado.getProyectos()) { // itero sus proyectos
                if(proyecto.equals(proyectoBuscado)){ // si el proyecto esta en el empleado
                    totalSalarios += empleado.getSalario(); // sumo su salario
                }
            }
        }
        return totalSalarios;
    }

    public List<Proyecto> proyectosUnicosDeEmpresa(Empresa empresa2){

        List<Proyecto> proyectosUnicos = new ArrayList<>();
        // El bucle que saque todos los proyectos
        for (Empleado empleado : empleados) {
            for (Proyecto proyecto : empleado.getProyectos()){
                proyectosUnicos.add(proyecto);
            }
        }

        // El bucle que compare los de la empresa2 con empresa1
        for (Empleado empleado2 : empresa2.getEmpleados()) {
            for (int i = 0; i < empleado2.getProyectos().size(); i++) {
                Proyecto proyecto2 = empleado2.getProyectos().get(i);
                proyectosUnicos.removeIf(proyecto -> proyectosUnicos.contains(proyecto2));
            }
        }
        return proyectosUnicos;
    }
}
