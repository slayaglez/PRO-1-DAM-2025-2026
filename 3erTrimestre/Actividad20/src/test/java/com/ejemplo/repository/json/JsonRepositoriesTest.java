package com.ejemplo.repository.json;

import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class JsonRepositoriesTest {

    @TempDir
    Path tempDir;

    private TestBackupManager backupManager;

    @BeforeEach
    void prepararCopiasDeSeguridad() {
        backupManager = new TestBackupManager(tempDir);
    }

    @Test
    void clienteJsonCrudWorks(){
        com.ejemplo.repository.json.ClienteJsonRepository repo = new com.ejemplo.repository.json.ClienteJsonRepository(backupManager.restaurarJson("clientes.json").toString());
        com.ejemplo.model.Cliente item = TestDataFactory.cliente1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setNombre("Ana Modificada"); assertTrue(repo.update(item)); assertEquals("Ana Modificada", repo.findById(1L).getNombre());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void productoJsonCrudWorks(){
        com.ejemplo.repository.json.ProductoJsonRepository repo = new com.ejemplo.repository.json.ProductoJsonRepository(backupManager.restaurarJson("productos.json").toString());
        com.ejemplo.model.Producto item = TestDataFactory.producto1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPrecio(99.99); assertTrue(repo.update(item)); assertEquals(99.99, repo.findById(1L).getPrecio());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void proveedorJsonCrudWorks(){
        com.ejemplo.repository.json.ProveedorJsonRepository repo = new com.ejemplo.repository.json.ProveedorJsonRepository(backupManager.restaurarJson("proveedores.json").toString());
        com.ejemplo.model.Proveedor item = TestDataFactory.proveedor1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPais("Francia"); assertTrue(repo.update(item)); assertEquals("Francia", repo.findById(1L).getPais());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void inventarioJsonCrudWorks(){
        com.ejemplo.repository.json.InventarioJsonRepository repo = new com.ejemplo.repository.json.InventarioJsonRepository(backupManager.restaurarJson("inventarios.json").toString());
        com.ejemplo.model.Inventario item = TestDataFactory.inventario1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setStockDisponible(50); assertTrue(repo.update(item)); assertEquals(50, repo.findById(1L).getStockDisponible());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void pedidoJsonCrudWorks(){
        com.ejemplo.repository.json.PedidoJsonRepository repo = new com.ejemplo.repository.json.PedidoJsonRepository(backupManager.restaurarJson("pedidos.json").toString());
        com.ejemplo.model.Pedido item = TestDataFactory.pedido1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setTotal(999.99); assertTrue(repo.update(item)); assertEquals(999.99, repo.findById(1L).getTotal());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void lineapedidoJsonCrudWorks(){
        com.ejemplo.repository.json.LineaPedidoJsonRepository repo = new com.ejemplo.repository.json.LineaPedidoJsonRepository(backupManager.restaurarJson("lineas_pedido.json").toString());
        com.ejemplo.model.LineaPedido item = TestDataFactory.linea1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setCantidad(5); assertTrue(repo.update(item)); assertEquals(5, repo.findById(1L).getCantidad());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void jsonRepositoryCreatesFileIfItDoesNotExist(){
        Path ruta = Path.of(tempDir.toString(), "clientes_nuevo.json");
        assertFalse(ruta.toFile().exists());

        new com.ejemplo.repository.json.ClienteJsonRepository(ruta.toString());

        assertTrue(ruta.toFile().exists());
    }

    @Test
    void jsonRepositoryRejectsRepeatedId(){
        com.ejemplo.repository.json.ClienteJsonRepository repo = new com.ejemplo.repository.json.ClienteJsonRepository(backupManager.restaurarJson("clientes_repetidos.json").toString());

        assertTrue(repo.create(TestDataFactory.cliente1()));
        assertFalse(repo.create(TestDataFactory.cliente1()));
        assertEquals(1, repo.findAll().size());
    }

}
