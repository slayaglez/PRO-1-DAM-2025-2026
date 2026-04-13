package com.ejemplo.repository.sqlite;

import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class SqliteRepositoriesTest {

    @TempDir
    Path tempDir;

    private SQLiteConnectionManager connectionManager;
    private TestBackupManager backupManager;

    @BeforeEach
    void init() throws Exception {
        backupManager = new TestBackupManager(tempDir);
        backupManager.restaurarSqlite("test.db");
    }


    @Test
    void clienteSqliteCrudWorks() throws Exception {
        com.ejemplo.repository.sqlite.ClienteSqliteRepository repo = new com.ejemplo.repository.sqlite.ClienteSqliteRepository(connectionManager);
        com.ejemplo.model.Cliente item = TestDataFactory.cliente1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setNombre("Ana SQL"); assertTrue(repo.update(item)); assertEquals("Ana SQL", repo.findById(1L).getNombre());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void productoSqliteCrudWorks() throws Exception {
        com.ejemplo.repository.sqlite.ProductoSqliteRepository repo = new com.ejemplo.repository.sqlite.ProductoSqliteRepository(connectionManager);
        com.ejemplo.model.Producto item = TestDataFactory.producto1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setStock(99); assertTrue(repo.update(item)); assertEquals(99, repo.findById(1L).getStock());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void proveedorSqliteCrudWorks() throws Exception {
        com.ejemplo.repository.sqlite.ProveedorSqliteRepository repo = new com.ejemplo.repository.sqlite.ProveedorSqliteRepository(connectionManager);
        com.ejemplo.model.Proveedor item = TestDataFactory.proveedor1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setPais("Italia"); assertTrue(repo.update(item)); assertEquals("Italia", repo.findById(1L).getPais());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void inventarioSqliteCrudWorks() throws Exception {
        com.ejemplo.repository.sqlite.InventarioSqliteRepository repo = new com.ejemplo.repository.sqlite.InventarioSqliteRepository(connectionManager);
        com.ejemplo.model.Inventario item = TestDataFactory.inventario1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setStockMinimo(1); assertTrue(repo.update(item)); assertEquals(1, repo.findById(1L).getStockMinimo());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void pedidoSqliteCrudWorks() throws Exception {
        com.ejemplo.repository.sqlite.PedidoSqliteRepository repo = new com.ejemplo.repository.sqlite.PedidoSqliteRepository(connectionManager);
        com.ejemplo.model.Pedido item = TestDataFactory.pedido1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setEstado("CANCELADO"); assertTrue(repo.update(item)); assertEquals("CANCELADO", repo.findById(1L).getEstado());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void lineapedidoSqliteCrudWorks() throws Exception {
        com.ejemplo.repository.sqlite.LineaPedidoSqliteRepository repo = new com.ejemplo.repository.sqlite.LineaPedidoSqliteRepository(connectionManager);
        com.ejemplo.model.LineaPedido item = TestDataFactory.linea1();

        assertTrue(repo.create(item));
        assertNotNull(repo.findById(1L));
        item.setSubtotal(55.0); assertTrue(repo.update(item)); assertEquals(55.0, repo.findById(1L).getSubtotal());
        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void sqliteRepositoryRejectsRepeatedId() throws Exception {
        com.ejemplo.repository.sqlite.ClienteSqliteRepository repo = new com.ejemplo.repository.sqlite.ClienteSqliteRepository(connectionManager);

        assertTrue(repo.create(TestDataFactory.cliente1()));
        assertFalse(repo.create(TestDataFactory.cliente1()));
        assertEquals(1, repo.findAll().size());
    }

}
