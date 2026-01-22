package com.docencia.listas.ejercicio7;

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

import com.docencia.herencia.ejercicio7.Dispositivo;
import com.docencia.herencia.ejercicio7.Telefono;

public class ListaDispositivosTest {

    private Dispositivo nuevoA(UUID id) {
        return new Telefono(id, "Samsung", "600000000");
    }

    private Dispositivo nuevoB(UUID id) {
        return new Telefono(id, "Dell", "61111111");
    }

    private Dispositivo invalido(UUID id) {
        return new Telefono(id, " ", "600000000");
    }

    @Test
    void anadirOkTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertEquals(1, l.tamanio());
        assertNotNull(l.buscarPorId(id));
    }

    @Test
    void anadirNullTest() {
        var l = new ListaDispositivos();
        assertThrows(IllegalArgumentException.class, () -> l.anadir(null));
    }

    @Test
    void anadirInvalidTest() {
        var l = new ListaDispositivos();
        assertThrows(IllegalArgumentException.class, () -> l.anadir(invalido(UUID.randomUUID())));
    }

    @Test
    void anadirDuplicadoIdTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.anadir(nuevoB(id)));
    }

    @Test
    void buscarPorIdOkTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertNotNull(l.buscarPorId(id));
    }

    @Test
    void buscarPorIdNullTest() {
        var l = new ListaDispositivos();
        assertThrows(IllegalArgumentException.class, () -> l.buscarPorId(null));
    }

    @Test
    void buscarPorIdNoExisteTest() {
        var l = new ListaDispositivos();
        assertNull(l.buscarPorId(UUID.randomUUID()));
    }

    @Test
    void eliminarPorIdOkTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertTrue(l.eliminarPorId(id));
        assertEquals(0, l.tamanio());
    }

    @Test
    void eliminarPorIdNullTest() {
        var l = new ListaDispositivos();
        assertThrows(IllegalArgumentException.class, () -> l.eliminarPorId(null));
    }

    @Test
    void eliminarPorIdNoExisteTest() {
        var l = new ListaDispositivos();
        assertFalse(l.eliminarPorId(UUID.randomUUID()));
    }

    @Test
    void modificarOkTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        l.modificar(id, nuevoB(id));
        assertEquals(1, l.tamanio());
        assertNotNull(l.buscarPorId(id));
    }

    @Test
    void modificarNullIdTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(null, nuevoB(id)));
    }

    @Test
    void modificarNullElementoTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(id, null));
    }

    @Test
    void modificarInvalidTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(id, invalido(id)));
    }

    @Test
    void modificarIdDistintoTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        l.anadir(nuevoA(id));
        assertThrows(IllegalArgumentException.class, () -> l.modificar(id, nuevoB(UUID.randomUUID())));
    }

    @Test
    void modificarNoExisteTest() {
        var l = new ListaDispositivos();
        var id = UUID.randomUUID();
        assertThrows(NoSuchElementException.class, () -> l.modificar(id, nuevoA(id)));
    }

    @Test
    void listarInmutableTest() {
        var l = new ListaDispositivos();
        l.anadir(nuevoA(UUID.randomUUID()));
        var vista = l.listar();
        assertThrows(UnsupportedOperationException.class, () -> vista.add(nuevoA(UUID.randomUUID())));
    }

    @Test
    void claseDocumentadaTest() throws Exception {
        String rel = "src/main/java/com/docencia/listas/ejercicio7/ListaDispositivos.java";
        String content = Files.readString(Path.of(rel));
        assertTrue(content.contains("/**"));
    }
}
