package com.docencia.ejercicio.clases.dos;

import java.util.HashSet;
import java.util.Set;

public class Programa2 {
    public static void main(String[] args) {
        System.out.println("== Pruebas Libro ==");

        // Constructores y toString
        Libro a = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        Libro b = new Libro("Otro", "Alguien", "9780132350884");       // mismo ISBN que 'a'
        Libro c = new Libro("Refactoring", "Martin Fowler", "032135668X"); // ISBN-10 con X
        Libro d = new Libro("Refactoring 2", "Martin Fowler", "032135668x"); // mismo que 'c' (casing distinto)

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        // equals y hashCode
        System.out.println("\n-- equals/hashCode --");
        System.out.println("a.equals(b) (mismo ISBN): " + a.equals(b)); // true
        System.out.println("c.equals(d) (X/x): " + c.equals(d));        // true
        System.out.println("hash(a) == hash(b): " + (a.hashCode() == b.hashCode()));

        // Comprobación con HashSet (no debe duplicar por mismo ISBN)
        Set<Libro> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println("\nTamaño del set (esperado 2): " + set.size());

        // Getters/Setters
        System.out.println("\n-- getters/setters --");
        b.setTitulo("Clean Code (Edición bolsillo)");
        b.setAutor("Robert C. Martin");
        System.out.println("b -> titulo=" + b.getTitulo() + ", autor=" + b.getAutor() + ", isbn=" + b.getIsbn());

        // Cambiar ISBN rompe la igualdad
        System.out.println("\n-- cambio de ISBN --");
        System.out.println("a.equals(b) antes: " + a.equals(b)); // true
        b.setIsbn("1111111111");
        System.out.println("a.equals(b) después: " + a.equals(b)); // false
        System.out.println(b);
    }
}
