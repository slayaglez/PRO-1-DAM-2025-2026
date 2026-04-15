package com.ejemplo.repository.csv;

import com.ejemplo.model.*;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class CsvRepositoriesTest {

    @TempDir
    Path tempDir;

    private TestBackupManager backupManager;

    @BeforeEach
    void prepararCopiasDeSeguridad() {
        backupManager = new TestBackupManager(tempDir);
    }

    @Test
    void clienteCsvCrudWorks() {
        ClienteCsvRepository repo = new ClienteCsvRepository(backupManager.restaurarCsv("clientes.csv").toString(), ";", ";");
        Cliente item = TestDataFactory.cliente1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setNombre("Ana Modificada"); assertTrue(repo.update(item)); assertEquals("Ana Modificada", repo.findById(1L).getNombre());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void productoCsvCrudWorks() {
        ProductoCsvRepository repo = new ProductoCsvRepository(backupManager.restaurarCsv("productos.csv").toString(), ";", ";");
        Producto item = TestDataFactory.producto1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPrecio(99.99); assertTrue(repo.update(item)); assertEquals(99.99, repo.findById(1L).getPrecio());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void proveedorCsvCrudWorks() {
        ProveedorCsvRepository repo = new ProveedorCsvRepository(backupManager.restaurarCsv("proveedores.csv").toString(), "\\|", "|");
        Proveedor item = TestDataFactory.proveedor1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPais("Francia"); assertTrue(repo.update(item)); assertEquals("Francia", repo.findById(1L).getPais());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void inventarioCsvCrudWorks() {
        InventarioCsvRepository repo = new InventarioCsvRepository(backupManager.restaurarCsv("inventarios.csv").toString(), "\\t", "\t");
        Inventario item = TestDataFactory.inventario1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setStockDisponible(50); assertTrue(repo.update(item)); assertEquals(50, repo.findById(1L).getStockDisponible());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void pedidoCsvCrudWorks() {
        PedidoCsvRepository repo = new PedidoCsvRepository(backupManager.restaurarCsv("pedidos.csv").toString(), ",", ",");
        Pedido item = TestDataFactory.pedido1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setTotal(999.99); assertTrue(repo.update(item)); assertEquals(999.99, repo.findById(1L).getTotal());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void lineapedidoCsvCrudWorks() {
        LineaPedidoCsvRepository repo = new LineaPedidoCsvRepository(backupManager.restaurarCsv("lineas_pedido.csv").toString(), "#", "#");
        LineaPedido item = TestDataFactory.linea1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setCantidad(5); assertTrue(repo.update(item)); assertEquals(5, repo.findById(1L).getCantidad());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void clienteCsvCreateFailsWhenIdRepeated() {
        ClienteCsvRepository repo = new ClienteCsvRepository(backupManager.restaurarCsv("clientes_repetidos.csv").toString(), ";", ";");

        assertTrue(repo.create(TestDataFactory.cliente1()));
        assertFalse(repo.create(TestDataFactory.cliente1()));
        assertEquals(1, repo.findAll().size());
    }

    @Test
    void csvRepositoryCreatesFileIfItDoesNotExist() {
        Path ruta = Path.of(tempDir.toString(), "nuevo_clientes.csv");
        assertFalse(ruta.toFile().exists());

        ClienteCsvRepository repo = new ClienteCsvRepository(ruta.toString(), ";", ";");

        assertTrue(ruta.toFile().exists());
    }

}
