package com.ejemplo.repository.csv;

import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

public class CsvRepositoriesTest {

    @TempDir
    Path tempDir;

    private TestBackupManager backupManager;

    @BeforeEach
    void prepararCopiasDeSeguridad() {
        backupManager = new TestBackupManager(tempDir);
    }

    @Test
    void clienteCsvCrudWorks() throws Exception {
        com.ejemplo.repository.csv.ClienteCsvRepository repo = new ClienteCsvRepository(backupManager.restaurarCsv("clientes.csv").toString(), ";", ";");
        com.ejemplo.model.Cliente item = TestDataFactory.cliente1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setNombre("Ana Modificada"); assertTrue(repo.update(item)); assertEquals("Ana Modificada", repo.findById(1L).getNombre());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void productoCsvCrudWorks() throws Exception {
        com.ejemplo.repository.csv.ProductoCsvRepository repo = new ProductoCsvRepository(backupManager.restaurarCsv("productos.csv").toString(), ";", ";");
        com.ejemplo.model.Producto item = TestDataFactory.producto1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPrecio(99.99); assertTrue(repo.update(item)); assertEquals(99.99, repo.findById(1L).getPrecio());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void proveedorCsvCrudWorks() throws Exception {
        com.ejemplo.repository.csv.ProveedorCsvRepository repo = new com.ejemplo.repository.csv.ProveedorCsvRepository(backupManager.restaurarCsv("proveedores.csv").toString(), "\\|", "|");
        com.ejemplo.model.Proveedor item = TestDataFactory.proveedor1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPais("Francia"); assertTrue(repo.update(item)); assertEquals("Francia", repo.findById(1L).getPais());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void inventarioCsvCrudWorks() throws Exception {
        com.ejemplo.repository.csv.InventarioCsvRepository repo = new com.ejemplo.repository.csv.InventarioCsvRepository(backupManager.restaurarCsv("inventarios.csv").toString(), "\\t", "\t");
        com.ejemplo.model.Inventario item = TestDataFactory.inventario1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setStockDisponible(50); assertTrue(repo.update(item)); assertEquals(50, repo.findById(1L).getStockDisponible());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void pedidoCsvCrudWorks() throws Exception {
        com.ejemplo.repository.csv.PedidoCsvRepository repo = new com.ejemplo.repository.csv.PedidoCsvRepository(backupManager.restaurarCsv("pedidos.csv").toString(), ",", ",");
        com.ejemplo.model.Pedido item = TestDataFactory.pedido1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setTotal(999.99); assertTrue(repo.update(item)); assertEquals(999.99, repo.findById(1L).getTotal());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void lineapedidoCsvCrudWorks() throws Exception {
        com.ejemplo.repository.csv.LineaPedidoCsvRepository repo = new com.ejemplo.repository.csv.LineaPedidoCsvRepository(backupManager.restaurarCsv("lineas_pedido.csv").toString(), "#", "#");
        com.ejemplo.model.LineaPedido item = TestDataFactory.linea1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setCantidad(5); assertTrue(repo.update(item)); assertEquals(5, repo.findById(1L).getCantidad());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void clienteCsvCreateFailsWhenIdRepeated() throws Exception {
        ClienteCsvRepository repo = new ClienteCsvRepository(backupManager.restaurarCsv("clientes_repetidos.csv").toString(), ";", ";");

        assertTrue(repo.create(TestDataFactory.cliente1()));
        assertFalse(repo.create(TestDataFactory.cliente1()));
        assertEquals(1, repo.findAll().size());
    }

    @Test
    void csvRepositoryCreatesFileIfItDoesNotExist() throws Exception {
        Path ruta = Path.of(tempDir.toString(), "nuevo_clientes.csv");
        assertFalse(ruta.toFile().exists());

        ClienteCsvRepository repo = new ClienteCsvRepository(ruta.toString(), ";", ";");

        assertTrue(ruta.toFile().exists());
    }

}
