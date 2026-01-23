package com.docencia.examen.colecciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.docencia.examen.herencia.Juego;
import com.docencia.examen.testutils.JuegosFixtures;

public class ExcepcionesYLogicaColeccionesTest {

    private static void cargar(Operaciones o) {
        o.crear(JuegosFixtures.arcade10()); // 22
        o.crear(JuegosFixtures.arcade20()); // 24
        o.crear(JuegosFixtures.mesa0());    // 35
        o.crear(JuegosFixtures.mesa10());   // 38.5
    }

    interface Operaciones {
        boolean crear(Juego j);
        Juego buscarId(String id);
        Juego buscarJuego(Juego j);
        boolean actualizar(Juego j);
        boolean eliminar(String id);
        boolean existe(String id);
        double calcularPrecio(String tipo);
        double calcularPrecioTotal();
        int contarPorTipo(String tipo);
        int contar();
    }

    @Nested class Lista {
        private final ListaJuegos g = new ListaJuegos();
        private final Operaciones o = new Operaciones() {
            public boolean crear(Juego j){ return g.crearJuego(j); }
            public Juego buscarId(String id){ return g.buscarId(id); }
            public Juego buscarJuego(Juego j){ return g.buscarJuego(j); }
            public boolean actualizar(Juego j){ return g.actualizarJuego(j); }
            public boolean eliminar(String id){ return g.eliminarId(id); }
            public boolean existe(String id){ return g.existeJuego(id); }
            public double calcularPrecio(String tipo){ return g.calcularPrecio(tipo); }
            public double calcularPrecioTotal(){ return g.calcularPrecioTotal(); }
            public int contarPorTipo(String tipo){ return g.contarPorTipo(tipo); }
            public int contar(){ return g.contar(); }
        };

        // EXCEPCIONES (más tests)
        @Test void crearJuegoTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.crear(null)); }
        @Test void buscarIdTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.buscarId(null)); }
        @Test void buscarIdTest_blank_lanza() { assertThrows(IllegalArgumentException.class, () -> o.buscarId(" ")); }
        @Test void eliminarIdTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.eliminar(null)); }
        @Test void existeJuegoTest_blank_lanza() { assertThrows(IllegalArgumentException.class, () -> o.existe(" ")); }
        @Test void calcularPrecioTest_tipoNull_lanza() { assertThrows(IllegalArgumentException.class, () -> o.calcularPrecio(null)); }
        @Test void contarPorTipoTest_tipoBlank_lanza() { assertThrows(IllegalArgumentException.class, () -> o.contarPorTipo(" ")); }
        @Test void buscarJuegoTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.buscarJuego(null)); }

        // CRUD + buscarJuego
        @Test void crearYBuscarJuegoTest_ok() {
            assertTrue(o.crear(JuegosFixtures.arcade10()));
            assertNotNull(o.buscarId("A1"));
            assertNotNull(o.buscarJuego(JuegosFixtures.arcade0("A1")));
        }
        @Test void crearJuegoTest_duplicado_false() {
            assertTrue(o.crear(JuegosFixtures.arcade10()));
            assertFalse(o.crear(JuegosFixtures.arcade0("A1")));
        }
        @Test void actualizarJuegoTest_noExiste_false() {
            assertFalse(o.actualizar(JuegosFixtures.arcade0("X")));
        }
        @Test void eliminarJuegoTest_noExiste_false() {
            assertFalse(o.eliminar("X"));
        }

        // LÓGICA (más tests)
        @Test void calcularPrecioTest_arcade() {
            cargar(o);
            assertEquals(46.0, o.calcularPrecio("ARCADE"), 0.0001);
        }
        @Test void calcularPrecioTest_mesa() {
            cargar(o);
            assertEquals(73.5, o.calcularPrecio("MESA"), 0.0001);
        }
        @Test void calcularPrecioTotalTest_suma() {
            cargar(o);
            assertEquals(119.5, o.calcularPrecioTotal(), 0.0001);
        }
        @Test void calcularPrecioTotalTest_vacio_cero() {
            assertEquals(0.0, o.calcularPrecioTotal(), 0.0001);
        }
        @Test void contarPorTipoTest_arcade() {
            cargar(o);
            assertEquals(2, o.contarPorTipo("ARCADE"));
        }
        @Test void contarPorTipoTest_inexistente_cero() {
            cargar(o);
            assertEquals(0, o.contarPorTipo("RPG"));
        }
    }

    @Nested class Set {
        private final SetJuegos g = new SetJuegos();
        private final Operaciones o = new Operaciones() {
            public boolean crear(Juego j){ return g.crearJuego(j); }
            public Juego buscarId(String id){ return g.buscarId(id); }
            public Juego buscarJuego(Juego j){ return g.buscarJuego(j); }
            public boolean actualizar(Juego j){ return g.actualizarJuego(j); }
            public boolean eliminar(String id){ return g.eliminarId(id); }
            public boolean existe(String id){ return g.existeJuego(id); }
            public double calcularPrecio(String tipo){ return g.calcularPrecio(tipo); }
            public double calcularPrecioTotal(){ return g.calcularPrecioTotal(); }
            public int contarPorTipo(String tipo){ return g.contarPorTipo(tipo); }
            public int contar(){ return g.contar(); }
        };

        @Test void crearJuegoTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.crear(null)); }
        @Test void buscarIdTest_blank_lanza() { assertThrows(IllegalArgumentException.class, () -> o.buscarId(" ")); }
        @Test void calcularPrecioTest_tipoBlank_lanza() { assertThrows(IllegalArgumentException.class, () -> o.calcularPrecio(" ")); }
        @Test void buscarJuegoTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.buscarJuego(null)); }

        @Test void calcularPrecioTotalTest_suma() { cargar(o); assertEquals(119.5, o.calcularPrecioTotal(), 0.0001); }
        @Test void contarPorTipoTest_mesa() { cargar(o); assertEquals(2, o.contarPorTipo("MESA")); }
        @Test void existeJuegoTest_true() { o.crear(JuegosFixtures.arcade10()); assertTrue(o.existe("A1")); }
        @Test void eliminarTest_ok() { o.crear(JuegosFixtures.arcade10()); assertTrue(o.eliminar("A1")); }
    }

    @Nested class Map {
        private final MapJuegos g = new MapJuegos();
        private final Operaciones o = new Operaciones() {
            public boolean crear(Juego j){ return g.crearJuego(j); }
            public Juego buscarId(String id){ return g.buscarId(id); }
            public Juego buscarJuego(Juego j){ return g.buscarJuego(j); }
            public boolean actualizar(Juego j){ return g.actualizarJuego(j); }
            public boolean eliminar(String id){ return g.eliminarId(id); }
            public boolean existe(String id){ return g.existeJuego(id); }
            public double calcularPrecio(String tipo){ return g.calcularPrecio(tipo); }
            public double calcularPrecioTotal(){ return g.calcularPrecioTotal(); }
            public int contarPorTipo(String tipo){ return g.contarPorTipo(tipo); }
            public int contar(){ return g.contar(); }
        };

        @Test void crearJuegoTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.crear(null)); }
        @Test void existeJuegoTest_null_lanza() { assertThrows(IllegalArgumentException.class, () -> o.existe(null)); }
        @Test void eliminarIdTest_blank_lanza() { assertThrows(IllegalArgumentException.class, () -> o.eliminar(" ")); }
        @Test void contarPorTipoTest_tipoNull_lanza() { assertThrows(IllegalArgumentException.class, () -> o.contarPorTipo(null)); }

        @Test void buscarJuegoTest_porIdDelObjeto() {
            o.crear(JuegosFixtures.arcade10());
            assertNotNull(o.buscarJuego(JuegosFixtures.arcade0("A1")));
        }

        @Test void calcularPrecioTest_arcade() { cargar(o); assertEquals(46.0, o.calcularPrecio("ARCADE"), 0.0001); }
        @Test void calcularPrecioTotalTest_suma() { cargar(o); assertEquals(119.5, o.calcularPrecioTotal(), 0.0001); }
        @Test void contarPorTipoTest_arcade() { cargar(o); assertEquals(2, o.contarPorTipo("ARCADE")); }
        @Test void actualizarTest_ok() {
            o.crear(JuegosFixtures.mesa0());
            assertTrue(o.actualizar(JuegosFixtures.mesa0("M1")));
        }
    }
}
