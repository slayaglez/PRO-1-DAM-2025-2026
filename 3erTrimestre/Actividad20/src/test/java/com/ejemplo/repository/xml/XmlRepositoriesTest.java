package com.ejemplo.repository.xml;

import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class XmlRepositoriesTest {

    @TempDir
    Path tempDir;

    private TestBackupManager backupManager;

    @BeforeEach
    void prepararCopiasDeSeguridad() {
        backupManager = new TestBackupManager(tempDir);
    }

    @Test
    void clienteXmlCrudWorks(){
        ClienteXmlRepository repo = new ClienteXmlRepository(backupManager.restaurarXml("clientes.xml").toString());
        com.ejemplo.model.Cliente item = TestDataFactory.cliente1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setNombre("Ana Modificada"); assertTrue(repo.update(item)); assertEquals("Ana Modificada", repo.findById(1L).getNombre());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void productoXmlCrudWorks(){
        ProductoXmlRepository repo = new ProductoXmlRepository(backupManager.restaurarXml("productos.xml").toString());
        com.ejemplo.model.Producto item = TestDataFactory.producto1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPrecio(99.99); assertTrue(repo.update(item)); assertEquals(99.99, repo.findById(1L).getPrecio());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void proveedorXmlCrudWorks(){
        ProveedorXmlRepository repo = new ProveedorXmlRepository(backupManager.restaurarXml("proveedores.xml").toString());
        com.ejemplo.model.Proveedor item = TestDataFactory.proveedor1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setPais("Francia"); assertTrue(repo.update(item)); assertEquals("Francia", repo.findById(1L).getPais());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void inventarioXmlCrudWorks(){
        InventarioXmlRepository repo = new InventarioXmlRepository(backupManager.restaurarXml("inventarios.xml").toString());
        com.ejemplo.model.Inventario item = TestDataFactory.inventario1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setStockDisponible(50); assertTrue(repo.update(item)); assertEquals(50, repo.findById(1L).getStockDisponible());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void pedidoXmlCrudWorks(){
        PedidoXmlRepository repo = new PedidoXmlRepository(backupManager.restaurarXml("pedidos.xml").toString());
        com.ejemplo.model.Pedido item = TestDataFactory.pedido1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setTotal(999.99); assertTrue(repo.update(item)); assertEquals(999.99, repo.findById(1L).getTotal());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void lineapedidoXmlCrudWorks(){
        LineaPedidoXmlRepository repo = new LineaPedidoXmlRepository(backupManager.restaurarXml("lineas_pedido.xml").toString());
        com.ejemplo.model.LineaPedido item = TestDataFactory.linea1();

        assertTrue(repo.create(item));
        assertEquals(1, repo.findAll().size());
        assertNotNull(repo.findById(1L));

        item.setCantidad(5); assertTrue(repo.update(item)); assertEquals(5, repo.findById(1L).getCantidad());

        assertTrue(repo.deleteById(1L));
        assertNull(repo.findById(1L));
    }

    @Test
    void xmlRepositoryCreatesFileIfItDoesNotExist(){
        Path ruta = Path.of(tempDir.toString(), "clientes_nuevo.xml");
        assertFalse(ruta.toFile().exists());

        new ClienteXmlRepository(ruta.toString());

        assertTrue(ruta.toFile().exists());
    }

    @Test
    void xmlRepositoryRejectsRepeatedId(){
        ClienteXmlRepository repo = new ClienteXmlRepository(backupManager.restaurarXml("clientes_repetidos.xml").toString());

        assertTrue(repo.create(TestDataFactory.cliente1()));
        assertFalse(repo.create(TestDataFactory.cliente1()));
        assertEquals(1, repo.findAll().size());
    }

}
