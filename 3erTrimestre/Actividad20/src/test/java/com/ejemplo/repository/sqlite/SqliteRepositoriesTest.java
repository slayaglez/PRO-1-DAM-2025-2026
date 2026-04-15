package com.ejemplo.repository.sqlite;

import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class SqliteRepositoriesTest {

    @TempDir
    Path tempDir;

    private TestBackupManager backupManager;

    @BeforeEach
    void init() {
        try {
            backupManager = new TestBackupManager(tempDir);   
        } catch (Exception e) {
            Assertions.fail("Se produjo un error al preparar la base de datos de prueba: " + e.getMessage());
        }
    }


    @Test
    void clienteSqliteCrudWorks() {
        ClienteSqliteRepository repo = new ClienteSqliteRepository();
        com.ejemplo.model.Cliente item = TestDataFactory.cliente1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setNombre("Ana SQL"); assertTrue(repo.update(item)); assertEquals("Ana SQL", repo.findById(1L).getNombre());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void productoSqliteCrudWorks()  {
        ProductoSqliteRepository repo = new ProductoSqliteRepository();
        com.ejemplo.model.Producto item = TestDataFactory.producto1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setStock(99); assertTrue(repo.update(item)); assertEquals(99, repo.findById(1L).getStock());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void proveedorSqliteCrudWorks() {
        ProveedorSqliteRepository repo = new ProveedorSqliteRepository();
        com.ejemplo.model.Proveedor item = TestDataFactory.proveedor1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setPais("Italia"); assertTrue(repo.update(item)); assertEquals("Italia", repo.findById(1L).getPais());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void inventarioSqliteCrudWorks() {
        InventarioSqliteRepository repo = new InventarioSqliteRepository();
        com.ejemplo.model.Inventario item = TestDataFactory.inventario1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setStockMinimo(1); assertTrue(repo.update(item)); assertEquals(1, repo.findById(1L).getStockMinimo());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void pedidoSqliteCrudWorks() {
        PedidoSqliteRepository repo = new PedidoSqliteRepository();
        com.ejemplo.model.Pedido item = TestDataFactory.pedido1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setEstado("CANCELADO"); assertTrue(repo.update(item)); assertEquals("CANCELADO", repo.findById(1L).getEstado());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void lineapedidoSqliteCrudWorks() {
        LineaPedidoSqliteRepository repo = new LineaPedidoSqliteRepository();
        com.ejemplo.model.LineaPedido item = TestDataFactory.linea1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setSubtotal(55.0); assertTrue(repo.update(item)); assertEquals(55.0, repo.findById(1L).getSubtotal());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void sqliteRepositoryRejectsRepeatedId() {
        ClienteSqliteRepository repo = new ClienteSqliteRepository();

        assertTrue(repo.create(TestDataFactory.cliente1()));
        assertFalse(repo.create(TestDataFactory.cliente1()));
        assertEquals(1, repo.findAll().size());
    }

}
