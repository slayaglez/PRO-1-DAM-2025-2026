package com.docencia.composicion.ejercicio17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief
 */
public class Ejercicio17 {

    public static void main(String[] args) {
        Proyecto proyecto1 = new Proyecto("Fuente", 12000);
        Proyecto proyecto2 = new Proyecto("Rotonda", 20000);
        Proyecto proyecto3 = new Proyecto("Casa", 160000);
        Proyecto proyecto4 = new Proyecto("Parque", 220000);
        Proyecto proyecto5 = new Proyecto("Piscina", 25000);

        List<Proyecto> publico = new ArrayList<>();
        publico.add(proyecto1);
        publico.add(proyecto2);
        publico.add(proyecto4);

        List<Proyecto> particular = new ArrayList<>();
        particular.add(proyecto3);
        particular.add(proyecto5);

        Empleado empleado1 = new Empleado("Sebas", 2000, publico);
        Empleado empleado2 = new Empleado("Javier", 2200, particular);
        Empleado empleado3 = new Empleado("Jorge", 2250, particular);

        List<Empleado> construccion = new ArrayList<>();
        construccion.add(empleado1);
        construccion.add(empleado2);
        construccion.add(empleado3);

        Empresa empresa1 = new Empresa(construccion);

        System.out.println(empresa1);
        System.out.println("\n");

        double totalSalarios = empresa1.totalSalariosDeProyecto(proyecto5);
        System.out.println("El total de los salarios de los que trabajan en la piscina es "+totalSalarios+" euros.");
    
        List<Empleado> cabildo = new ArrayList<>();
        cabildo.add(empleado1);
        Empresa empresa2 = new Empresa(cabildo);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println(empresa1);
        System.out.println("\n");
        System.out.println(empresa2);
        System.out.println("\n");
        System.out.println("\n");

        List<Proyecto> proyectosUnicos = new ArrayList<>();
        proyectosUnicos = empresa1.proyectosUnicosDeEmpresa(empresa2);
        System.out.println(proyectosUnicos);
    }
}
