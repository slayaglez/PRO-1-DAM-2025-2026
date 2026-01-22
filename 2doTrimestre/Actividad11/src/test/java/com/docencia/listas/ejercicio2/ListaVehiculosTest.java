package com.docencia.listas.ejercicio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.docencia.herencia.ejercicio2.Coche;
import com.docencia.herencia.ejercicio2.Vehiculo;

public class ListaVehiculosTest {

    private Vehiculo nuevoA(UUID id) {
        return new Coche(id, "Toyota", "Corolla", 5);
    }

    private Vehiculo nuevoB(UUID id) {
        return new Coche(id, "Honda", "CB500", 5);
    }

    private Vehiculo invalido(UUID id) {
        return new Coche(id, " ", "Corolla", 5);
    }

    @Test
    void anadirOkTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertEquals(1, l.tamanio());
        assertNotNull(l.buscarPorId(id));
    }

    @Test
    void anadirNullTest() {
        var l = new ListaVehiculos();
        assertThrows(IllegalArgumentException.class, () -> l.anadir(null));
    }

    @Test
    void anadirInvalidTest() {
        var l = new ListaVehiculos();
        assertThrows(IllegalArgumentException.class, () -> l.anadir(invalido(UUID.randomUUID())));
    }

    @Test
    void anadirDuplicadoIdTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.anadir(nuevoB(id)));
    }

    @Test
    void buscarPorIdOkTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertNotNull(l.buscarPorId(id));
    }

    @Test
    void buscarPorIdNullTest() {
        var l = new ListaVehiculos();
        assertThrows(IllegalArgumentException.class, () -> l.buscarPorId(null));
    }

    @Test
    void buscarPorIdNoExisteTest() {
        var l = new ListaVehiculos();
        assertNull(l.buscarPorId(UUID.randomUUID()));
    }

    @Test
    void eliminarPorIdOkTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertTrue(l.eliminarPorId(id));
        assertEquals(0, l.tamanio());
    }

    @Test
    void eliminarPorIdNullTest() {
        var l = new ListaVehiculos();
        assertThrows(IllegalArgumentException.class, () -> l.eliminarPorId(null));
    }

    @Test
    void eliminarPorIdNoExisteTest() {
        var l = new ListaVehiculos();
        assertFalse(l.eliminarPorId(UUID.randomUUID()));
    }

    @Test
    void modificarOkTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        l.modificar(id, nuevoB(id));
        assertEquals(1, l.tamanio());
        assertNotNull(l.buscarPorId(id));
    }

    @Test
    void modificarNullIdTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(null, nuevoB(id)));
    }

    @Test
    void modificarNullElementoTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(id, null));
    }

    @Test
    void modificarInvalidTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(id, invalido(id)));
    }

    @Test
    void modificarIdDistintoTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(id, nuevoB(UUID.randomUUID())));
    }

    @Test
    void modificarNoExisteTest() {
        var l = new ListaVehiculos();
        var id = UUID.randomUUID();
        assertThrows(NoSuchElementException.class, () -> l.modificar(id, nuevoA(id)));
    }

    @Test
    void listarInmutableTest() {
        var l = new ListaVehiculos();
        l.anadir(nuevoA(UUID.randomUUID()));
        var vista = l.listar();
        assertThrows(UnsupportedOperationException.class, () -> vista.add(nuevoA(UUID.randomUUID())));
    }

    @Test
    void claseDocumentadaTest() throws Exception {
        String rel = "src/main/java/com/docencia/listas/ejercicio2/ListaVehiculos.java";
        String content = Files.readString(Path.of(rel));
        assertTrue(content.contains("/**"));
    }
}
