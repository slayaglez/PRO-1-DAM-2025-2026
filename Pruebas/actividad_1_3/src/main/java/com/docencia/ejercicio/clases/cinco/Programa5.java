package com.docencia.ejercicio.clases.cinco;

public class Programa5 {
    public static void main(String[] args) {
        System.out.println("== Pruebas Estudiante ==");

        // Constructores y toString
        Estudiante estudiante1 = new Estudiante("111A", "Lucía");
        Estudiante estudiante2 = new Estudiante("111a", "Lucía G."); // mismo DNI (casing distinto)
        Estudiante estudiante3 = new Estudiante("222B", "Hugo");

        System.out.println("estudiante1: " + estudiante1);
        System.out.println("estudiante2: " + estudiante2);
        System.out.println("estudiante3: " + estudiante3);

        // equals (por DNI, ignoreCase)
        System.out.println("\n-- equals --");
        System.out.println("estudiante1.equals(estudiante2): " + estudiante1.equals(estudiante2)); // true
        System.out.println("estudiante1.equals(estudiante3): " + estudiante1.equals(estudiante3)); // false
        System.out.println("estudiante1.equals(null): " + estudiante1.equals(null));               // false

        // Getters / Setters
        System.out.println("\n-- getters/setters --");
        System.out.println("Nombre estudiante3 (antes): " + estudiante3.getNombre());
        estudiante3.setNombre("Hugo P.");
        System.out.println("Nombre estudiante3 (después): " + estudiante3.getNombre());

        System.out.println("DNI estudiante3 (antes): " + estudiante3.getDni());
        estudiante3.setDni("222B-NEW");
        System.out.println("DNI estudiante3 (después): " + estudiante3.getDni());

        // Cambio de DNI y efecto en equals
        System.out.println("\n-- cambio de DNI --");
        System.out.println("estudiante1.equals(estudiante2) antes: " + estudiante1.equals(estudiante2)); // true
        estudiante2.setDni("333C");
        System.out.println("estudiante1.equals(estudiante2) después: " + estudiante1.equals(estudiante2)); // false
        System.out.println("estudiante2 actualizado: " + estudiante2);

        // Listado rápido (usa toString)
        System.out.println("\n-- listado --");
        Estudiante[] listado = { estudiante1, estudiante2, estudiante3 };
        for (int i = 0; i < listado.length; i++) {
            System.out.printf("%d) %s%n", i + 1, listado[i]);
        }

        System.out.println("\nPruebas completas.");
    }
}
