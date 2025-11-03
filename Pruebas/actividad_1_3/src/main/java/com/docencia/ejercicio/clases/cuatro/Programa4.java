package com.docencia.ejercicio.clases.cuatro;

public class Programa4 {
    public static void main(String[] args) {
        System.out.println("== Pruebas Coche ==");

        // Constructores y toString
        Coche coche1 = new Coche(); // sin datos
        Coche coche2 = new Coche("1234-ABC", "Toyota", "Corolla", 2018);
        Coche coche3 = new Coche("1234-abc"); // misma matrícula (casing distinto)
        coche3.setMarca("Toyota");
        coche3.setModelo("Auris");
        coche3.setAnio(2016);
        Coche c3 = new Coche("9999-ZZZ", "SEAT", "Ibiza", 2020); // otro coche distinto

        System.out.println("coche1: " + coche1);
        System.out.println("coche2: " + coche2);
        System.out.println("coche3: " + coche3);
        System.out.println("c3: " + c3);

        // equals (por matrícula, ignoreCase)
        System.out.println("\n-- equals --");
        System.out.println("coche2.equals(coche3): " + coche2.equals(coche3)); // true (misma matrícula)
        System.out.println("coche2.equals(c3): " + coche2.equals(c3));         // false
        System.out.println("coche2.equals(null): " + coche2.equals(null));      // false

        // Getters / Setters
        System.out.println("\n-- getters/setters --");
        System.out.println("Antes -> coche1: " + coche1);
        coche1.setMatricula("0000-AAA");
        coche1.setMarca("Ford");
        coche1.setModelo("Focus");
        coche1.setAnio(2012);
        System.out.println("Después -> coche1: " + coche1);
        System.out.printf("coche1.getMatricula()=%s, getMarca()=%s, getModelo()=%s, getAnio()=%d%n",
                coche1.getMatricula(), coche1.getMarca(), coche1.getModelo(), coche1.getAnio());

        // Cambio de matrícula y efecto en equals
        System.out.println("\n-- cambio de matrícula --");
        System.out.println("coche2.equals(coche3) antes: " + coche2.equals(coche3)); // true
        coche3.setMatricula("1234-XYZ");
        System.out.println("coche2.equals(coche3) después: " + coche2.equals(coche3)); // false
        System.out.println("coche3 actualizado: " + coche3);

        System.out.println("\nPruebas completas.");
    }
}
