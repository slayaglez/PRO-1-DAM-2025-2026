package es.docencia.clases;

public class Programa {
    public static void main(String[] args) {
        Persona persona1;
        persona1 = new Persona("43387878B");
        persona1.setFechaNacimiento("22/01/2004");
        persona1.setNombre("Cbas");
        System.out.println(persona1);

        Persona persona2;
        persona2 = new Persona("433121212C");
        if (persona1.equals(persona2)) {
            System.out.println("Somos la misma persona");
        }

        Persona persona3;
        persona3 = new Persona("43387878B");
        if (persona1.equals(persona3)) {
            System.out.println("Somos la misma persona");
        }
    }
}
