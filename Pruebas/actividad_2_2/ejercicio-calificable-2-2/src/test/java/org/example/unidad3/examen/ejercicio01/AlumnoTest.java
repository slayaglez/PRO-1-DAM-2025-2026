package org.example.unidad3.examen.ejercicio01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import org.docencia.unidad3.examen.ejercicio01.Alumno;

public class AlumnoTest {

    // ---------- Constructores ----------

    @Test
    void constructorVacioDeberiaCrearAlumnoConValoresPorDefecto() {
        Alumno alumno = new Alumno();

        // Por diseño: nombre null, nota 0
        assertNull(alumno.getNombre());
        assertEquals(0, alumno.getNota());
        assertEquals("Insuficiente", alumno.getCalificacionTexto());
    }

    @Test
    void constructorCompletoDeberiaAsignarNombreYNota() {
        Alumno alumno = new Alumno("Ana", 8);

        assertEquals("Ana", alumno.getNombre());
        assertEquals(8, alumno.getNota());
        assertEquals("Notable", alumno.getCalificacionTexto());
    }

    @Test
    void constructorCompletoDeberiaLanzarExcepcionSiNotaMenorQueCero() {
        assertThrows(IllegalArgumentException.class,
                () -> new Alumno("Ana", -1));
    }

    @Test
    void constructorCompletoDeberiaLanzarExcepcionSiNotaMayorQueDiez() {
        assertThrows(IllegalArgumentException.class,
                () -> new Alumno("Ana", 11));
    }

    // ---------- Getters y setters ----------

    @Test
    void setterNombreDeberiaActualizarElNombre() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Pepe");

        assertEquals("Pepe", alumno.getNombre());
    }

    @Test
    void setterNotaDeberiaAceptarValorValido() {
        Alumno alumno = new Alumno();
        alumno.setNota(6);

        assertEquals(6, alumno.getNota());
        assertEquals("Bien", alumno.getCalificacionTexto());
    }

    @Test
    void setterNotaDeberiaLanzarExcepcionSiNotaMenorQueCero() {
        Alumno alumno = new Alumno("Luis", 5);

        assertThrows(IllegalArgumentException.class,
                () -> alumno.setNota(-3));
    }

    @Test
    void setterNotaDeberiaLanzarExcepcionSiNotaMayorQueDiez() {
        Alumno alumno = new Alumno("Luis", 5);

        assertThrows(IllegalArgumentException.class,
                () -> alumno.setNota(15));
    }

    // ---------- getCalificacionTexto ----------

    @ParameterizedTest
    @CsvSource({
            "0,Insuficiente",
            "3,Insuficiente",
            "4,Insuficiente",
            "5,Suficiente",
            "6,Bien",
            "7,Notable",
            "8,Notable",
            "9,Sobresaliente",
            "10,Sobresaliente"
    })
    void getCalificacionTextoDeberiaDevolverTextoCorrecto(int nota, String textoEsperado) {
        Alumno alumno = new Alumno("Test", nota);

        assertEquals(textoEsperado, alumno.getCalificacionTexto());
    }

    // ---------- equals y hashCode ----------

    @Test
    void equalsDeberiaSerVerdaderoParaObjetosConMismoNombreYNota() {
        Alumno a1 = new Alumno("Ana", 8);
        Alumno a2 = new Alumno("Ana", 8);

        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    void equalsDeberiaSerFalsoSiNombreODNotaSonDistintos() {
        Alumno a1 = new Alumno("Ana", 8);
        Alumno a2 = new Alumno("Ana", 7);
        Alumno a3 = new Alumno("Luis", 8);

        assertNotEquals(a1, a2);
        assertNotEquals(a1, a3);
    }

    @Test
    void equalsDeberiaSerFalsoSiComparoConNullOuOtraClase() {
        Alumno a1 = new Alumno("Ana", 8);

        assertNotEquals(a1, null);
        assertNotEquals(a1, "cadena");
    }

    // ---------- toString ----------

    @Test
    void toStringDeberiaIncluirNombreNotaYCalificacion() {
        Alumno alumno = new Alumno("Ana", 9);

        String texto = alumno.toString();

        assertTrue(texto.contains("Ana"));
        assertTrue(texto.contains("9"));
        assertTrue(texto.contains("Sobresaliente"));
    }
}
