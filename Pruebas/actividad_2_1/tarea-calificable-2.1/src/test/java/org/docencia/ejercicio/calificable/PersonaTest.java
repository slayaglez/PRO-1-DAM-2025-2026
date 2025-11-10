package org.docencia.ejercicio.calificable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void constructoresTest() {
        Persona vacia = new Persona();
        assertNull(vacia.getId());
        assertNull(vacia.getNombre());
        assertEquals(0, vacia.getEdad());

        Persona p = new Persona("A1", "Ana", 30);
        assertEquals("A1", p.getId());
        assertEquals("Ana", p.getNombre());
        assertEquals(30, p.getEdad());

            }

    @Test
    void gettersYSettersTest() {
        Persona p = new Persona();
        p.setId("B2");
        p.setNombre("Bruno");
        p.setEdad(25);

        assertAll(
                () -> assertEquals("B2", p.getId()),
                () -> assertEquals("Bruno", p.getNombre()),
                () -> assertEquals(25, p.getEdad())
        );

        p.setNombre("Bruno Díaz");
        p.setEdad(26);
        assertEquals("Bruno Díaz", p.getNombre());
        assertEquals(26, p.getEdad());
    }

    @Test
    void equalsYHashCodeTest() {
        Persona p1 = new Persona("X", "Ximena", 20);
        Persona p2 = new Persona("X", "OtroNombre", 99); // mismo id, resto distinto
        Persona p3 = new Persona("X", "Otra", 10);
        Persona p4 = new Persona("Y", "Yago", 20);
        Persona sinId1 = new Persona(null, "N", 1);
        Persona sinId2 = new Persona(null, "N", 1);

        assertEquals(p1, p1);

        assertTrue(p1.equals(p2) && p2.equals(p1));

        assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));

        assertEquals(p1.hashCode(), p2.hashCode());

        assertNotEquals(p1, p4);

        assertNotEquals(p1, null);
        assertNotEquals(p1, "no es persona");

        assertNotEquals(sinId1, sinId2);
        assertEquals(sinId1, sinId1);
    }

    @Test
    void toStringNoEsNuloTest() {
        Persona p = new Persona("Z", "Zulema", 40);
        assertNotNull(p.toString());
        assertTrue(p.toString().contains("Persona"));
    }
}

