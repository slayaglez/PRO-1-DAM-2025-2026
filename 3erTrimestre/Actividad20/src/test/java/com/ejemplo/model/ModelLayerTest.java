package com.ejemplo.model;

import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelLayerTest {

    @Test
    void clienteModelWorks() {
        Cliente cliente = TestDataFactory.cliente1();
        assertEquals(1L, cliente.getId());
        assertEquals("Ana", cliente.getNombre());
        assertTrue(cliente.isActivo());
    }

    @Test
    void clienteModelAllowsSetters() {
        Cliente cliente = TestDataFactory.cliente1();
        cliente.setNombre("Ana Maria");
        cliente.setActivo(false);
        assertEquals("Ana Maria", cliente.getNombre());
        assertFalse(cliente.isActivo());
    }

    @Test
    void productoModelWorks() {
        Producto producto = TestDataFactory.producto1();
        assertEquals("P001", producto.getSku());
        assertEquals(25.5, producto.getPrecio());
    }

    @Test
    void productoModelToStringContainsNombre() {
        Producto producto = TestDataFactory.producto1();
        assertTrue(producto.toString().contains("Teclado"));
    }

    @Test
    void proveedorModelWorks() {
        Proveedor p = TestDataFactory.proveedor1();
        assertEquals("PR001", p.getCodigo());
    }

    @Test
    void proveedorModelsWithSameIdAreEqual() {
        Proveedor proveedor1 = TestDataFactory.proveedor1();
        Proveedor proveedor2 = TestDataFactory.proveedor1();
        assertEquals(proveedor1, proveedor2);
    }

    @Test
    void inventarioModelWorks() {
        Inventario inventario = TestDataFactory.inventario1();
        assertEquals("A1", inventario.getUbicacion());
    }

    @Test
    void inventarioModelAllowsChangingStock() {
        Inventario inventario = TestDataFactory.inventario1();
        inventario.setStockDisponible(20);
        assertEquals(20, inventario.getStockDisponible());
    }

    @Test
    void pedidoModelWorks() {
        Pedido pedido = TestDataFactory.pedido1();
        assertEquals("PAGADO", pedido.getEstado());
    }

    @Test
    void pedidoModelToStringContainsNumero() {
        Pedido pedido = TestDataFactory.pedido1();
        assertTrue(pedido.toString().contains("PD001"));
    }

    @Test
    void lineaPedidoModelWorks() {
        LineaPedido linea = TestDataFactory.linea1();
        assertEquals(25.50, linea.getSubtotal());
    }

    @Test
    void lineaPedidoModelAllowsUpdatingCantidad() {
        LineaPedido linea = TestDataFactory.linea1();
        linea.setCantidad(3);
        assertEquals(3, linea.getCantidad());
    }
}
