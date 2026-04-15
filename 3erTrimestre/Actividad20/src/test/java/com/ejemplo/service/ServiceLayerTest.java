package com.ejemplo.service;

import com.ejemplo.model.*;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceLayerTest {

    @Test
    void clienteServiceWorks() throws Exception {
        ClienteService service = new ClienteService(new InMemoryClienteRepository());
        assertTrue(service.crear(TestDataFactory.cliente1()));
        assertEquals(1, service.listarActivos().size());
        assertEquals(1, service.buscarPorPais("España").size());
    }

    @Test
    void productoServiceCalculatesValues() throws Exception {
        ProductoService service = new ProductoService(new InMemoryProductoRepository());
        assertTrue(service.crear(TestDataFactory.producto1()));
        assertTrue(service.crear(TestDataFactory.producto2()));
        assertEquals(19.245, service.calcularPrecioMedio(), 0.001);
        assertEquals(644.7, service.calcularValorTotalStock(), 0.01);
        assertEquals(40, service.calcularStockTotal());
    }

    @Test
    void proveedorServiceWorks() throws Exception {
        ProveedorService service = new ProveedorService(new InMemoryProveedorRepository());
        assertTrue(service.crear(TestDataFactory.proveedor1()));
        assertEquals(1, service.buscarPorPais("España").size());
    }

    @Test
    void inventarioServiceWorks() throws Exception {
        InventarioService service = new InventarioService(new InMemoryInventarioRepository());
        assertTrue(service.crear(TestDataFactory.inventario1()));
        assertTrue(service.crear(TestDataFactory.inventario2()));
        assertEquals(11, service.calcularStockTotal());
        assertEquals(1, service.stockBajo().size());
    }

    @Test
    void pedidoServiceWorks() throws Exception {
        PedidoService service = new PedidoService(new InMemoryPedidoRepository());
        assertTrue(service.crear(TestDataFactory.pedido1()));
        assertTrue(service.crear(TestDataFactory.pedido2()));
        assertEquals(238.39, service.calcularImporteTotalPedidos(), 0.001);
        assertEquals("PD002", service.obtenerPedidoMayorImporte().getNumero());
    }

    @Test
    void lineaPedidoServiceWorks() throws Exception {
        LineaPedidoService service = new LineaPedidoService(new InMemoryLineaPedidoRepository());
        assertTrue(service.crear(TestDataFactory.linea1()));
        assertTrue(service.crear(TestDataFactory.linea2()));
        assertEquals(38.49, service.calcularFacturacionTotal(), 0.001);
        assertEquals(2, service.calcularCantidadTotalVendida());
    }

    @Test
    void clienteServiceRejectsInvalidCliente() throws Exception {
        ClienteService service = new ClienteService(new InMemoryClienteRepository());
        Cliente cliente = TestDataFactory.cliente1();
        cliente.setNombre(" ");

        assertFalse(service.crear(cliente));
        assertEquals(0, service.listarTodos().size());
    }

    @Test
    void productoServiceFindsStockBajo() throws Exception {
        ProductoService service = new ProductoService(new InMemoryProductoRepository());
        assertTrue(service.crear(TestDataFactory.producto1()));
        assertTrue(service.crear(TestDataFactory.producto2()));

        assertEquals(1, service.stockBajo(20).size());
    }

    @Test
    void proveedorServiceCanDelete() throws Exception {
        ProveedorService service = new ProveedorService(new InMemoryProveedorRepository());
        assertTrue(service.crear(TestDataFactory.proveedor1()));

        assertTrue(service.eliminar(1L));
        assertNull(service.buscarPorId(1L));
    }

    @Test
    void inventarioServiceBuscaPorUbicacion() throws Exception {
        InventarioService service = new InventarioService(new InMemoryInventarioRepository());
        assertTrue(service.crear(TestDataFactory.inventario1()));
        assertTrue(service.crear(TestDataFactory.inventario2()));

        assertEquals(1, service.buscarPorUbicacion("A1").size());
    }

    @Test
    void pedidoServiceFiltraPorEstadoYCliente() throws Exception {
        PedidoService service = new PedidoService(new InMemoryPedidoRepository());
        assertTrue(service.crear(TestDataFactory.pedido1()));
        assertTrue(service.crear(TestDataFactory.pedido2()));

        assertEquals(1, service.listarPorEstado("PAGADO").size());
        assertEquals(1, service.listarPorCliente(2L).size());
    }

    @Test
    void lineaPedidoServiceListaPorPedido() throws Exception {
        LineaPedidoService service = new LineaPedidoService(new InMemoryLineaPedidoRepository());
        assertTrue(service.crear(TestDataFactory.linea1()));
        assertTrue(service.crear(TestDataFactory.linea2()));

        assertEquals(2, service.listarPorPedido(1L).size());
    }
}
