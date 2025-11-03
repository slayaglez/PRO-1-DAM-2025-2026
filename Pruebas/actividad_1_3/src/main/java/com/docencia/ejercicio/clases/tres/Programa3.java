package com.docencia.ejercicio.clases.tres;

import java.util.HashSet;
import java.util.Set;

public class Programa3 {
    public static void main(String[] args) {
        System.out.println("== Pruebas CuentaBancaria ==");

        // Constructores y toString
        CuentaBancaria cuenta1 = new CuentaBancaria("Ana", "ES12-3456");
        CuentaBancaria cuenta2 = new CuentaBancaria("Ana María", "es12-3456", 100.0); // mismo número (diferente casing)
        CuentaBancaria cuenta3 = new CuentaBancaria("Luis", "XX00-0001", 250.5);

        System.out.println(cuenta1); // ES12-3456 - Ana - saldo=0.0
        System.out.println(cuenta2); // es12-3456 - Ana María - saldo=100.0
        System.out.println(cuenta3); // XX00-0001 - Luis - saldo=250.5

        // equals y hashCode (igualdad por número de cuenta, ignoreCase)
        System.out.println("\n-- equals/hashCode --");
        System.out.println("a.equals(b) (mismo número): " + cuenta1.equals(cuenta2)); // true
        System.out.println("a.hashCode() == b.hashCode(): " + (cuenta1.hashCode() == cuenta2.hashCode()));
        System.out.println("a.equals(c): " + cuenta1.equals(cuenta3)); // false
        System.out.println("a.equals(null): " + cuenta1.equals(null)); // false

        // Getters / Setters
        System.out.println("\n-- getters/setters --");
        System.out.println("Titular c (antes): " + cuenta3.getTitular());
        cuenta3.setTitular("Luis P.");
        System.out.println("Titular c (después): " + cuenta3.getTitular());

        System.out.println("Número c (antes): " + cuenta3.getNumero());
        cuenta3.setNumero("XX00-0002");
        System.out.println("Número c (después): " + cuenta3.getNumero());

        // Cambiar el número rompe la igualdad
        System.out.println("\n-- cambio de número --");
        System.out.println("a.equals(b) antes: " + cuenta1.equals(cuenta2)); // true
        cuenta2.setNumero("ES12-9999");
        System.out.println("a.equals(b) después: " + cuenta1.equals(cuenta2)); // false
        System.out.println("b -> " + cuenta2);

        // Listado rápido (usa toString)
        System.out.println("\n-- listado --");
        CuentaBancaria[] arrayCuentas = { cuenta1, cuenta2, cuenta3 };
        for (int i = 0; i < arrayCuentas.length; i++) {
            System.out.printf("%d) %s%n", i + 1, arrayCuentas[i]);
        }

        System.out.println("\nPruebas completas.");
    }
}
