package com.ejemplo.model.xml;

import com.ejemplo.support.TestDataFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class XmlCollectionsTest {

    @Test
    void deberiaGestionarClientes() {
        Clientes clientes = new Clientes();
        clientes.setItems(List.of(TestDataFactory.cliente1()));
        assertEquals(1, clientes.getItems().size());

        Clientes wrapperConConstructor = new Clientes(List.of(TestDataFactory.cliente2()));
        assertEquals(1, wrapperConConstructor.getItems().size());
    }

    @Test
    void deberiaGestionarProductos() {
        Productos productos = new Productos();
        productos.setItems(List.of(TestDataFactory.producto1()));
        assertEquals(1, productos.getItems().size());

        Productos wrapperConConstructor = new Productos(List.of(TestDataFactory.producto2()));
        assertEquals(1, wrapperConConstructor.getItems().size());
    }

    @Test
    void deberiaGestionarProveedores() {
        Proveedores proveedores = new Proveedores();
        proveedores.setItems(List.of(TestDataFactory.proveedor1()));
        assertEquals(1, proveedores.getItems().size());

        Proveedores wrapperConConstructor = new Proveedores(List.of(TestDataFactory.proveedor2()));
        assertEquals(1, wrapperConConstructor.getItems().size());
    }

    @Test
    void deberiaGestionarInventarios() {
        Inventarios wrapper = new Inventarios();
        wrapper.setItems(List.of(TestDataFactory.inventario1()));
        assertEquals(1, wrapper.getItems().size());

        Inventarios wrapperConConstructor = new Inventarios(List.of(TestDataFactory.inventario2()));
        assertEquals(1, wrapperConConstructor.getItems().size());
    }

    @Test
    void deberiaGestionarPedidos() {
        Pedidos pedidos = new Pedidos();
        pedidos.setItems(List.of(TestDataFactory.pedido1()));
        assertEquals(1, pedidos.getItems().size());

        Pedidos wrapperConConstructor = new Pedidos(List.of(TestDataFactory.pedido2()));
        assertEquals(1, wrapperConConstructor.getItems().size());
    }

    @Test
    void deberiaGestionarLineasPedido() {
        LineasPedido lineasPedido = new LineasPedido();
        lineasPedido.setItems(List.of(TestDataFactory.linea1()));
        assertEquals(1, lineasPedido.getItems().size());

        LineasPedido wrapperConConstructor = new LineasPedido(List.of(TestDataFactory.linea2()));
        assertEquals(1, wrapperConConstructor.getItems().size());
    }
}
