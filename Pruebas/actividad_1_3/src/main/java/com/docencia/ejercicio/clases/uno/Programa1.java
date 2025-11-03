package com.docencia.ejercicio.clases.uno;
public class Programa1 {
public static void main(String[] args) {
        System.out.println("== Pruebas Punto2D ==");

        Punto2D p0 = new Punto2D();               
        Punto2D p1 = new Punto2D(1.5, 2.0);
        Punto2D p2 = new Punto2D(1.5, 2.0);

        System.out.println("p0 = " + p0);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);

        System.out.println("\n-- equals/hashCode --");
        System.out.println("p1.equals(p2): " + p1.equals(p2)); 
        System.out.println("hash(p1) == hash(p2): " + (p1.hashCode() == p2.hashCode()));
        System.out.println("p1.equals(null): " + p1.equals(null));             
        System.out.println("p1.equals(new Object()): " + p1.equals(new Object())); 

        // Getters/Setters
        System.out.println("\n-- getters/setters --");
        p0.setX(3.0);
        p0.setY(-4.0);
        System.out.printf("p0 -> x=%.1f, y=%.1f%n", p0.getX(), p0.getY());

        // Propiedades de equals (reflexiva, simétrica, transitiva)
        System.out.println("\n-- propiedades equals --");
        boolean reflexiva = p1.equals(p1);
        boolean simetrica = p1.equals(p2) && p2.equals(p1);
        Punto2D p3 = new Punto2D(1.5, 2.0);
        boolean transitiva = p1.equals(p2) && p2.equals(p3) && p1.equals(p3);
        System.out.println("Reflexiva:  " + reflexiva);
        System.out.println("Simétrica:  " + simetrica);
        System.out.println("Transitiva: " + transitiva);

        // Cambio de estado rompe la igualdad
        System.out.println("\n-- mutación y comparación --");
        p2.setY(2.1);
        System.out.println("Tras p2.setY(2.1): p1.equals(p2) -> " + p1.equals(p2)); // false

        // Listado rápido (usa toString)
        System.out.println("\n-- listado --");
        Punto2D[] arr = { p0, p1, p2, p3 };
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d) %s%n", i + 1, arr[i]);
        }

        System.out.println("\nPruebas completas.");
    }

    /** Comparación aproximada para dobles. */
    private static boolean approx(double a, double b, double eps) {
        double denom = Math.max(1.0, Math.max(Math.abs(a), Math.abs(b)));
        return Math.abs(a - b) <= eps * denom;
    }
}
