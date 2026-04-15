package com.ejemplo.support;

import com.ejemplo.model.*;

public class TestDataFactory {

    private TestDataFactory() {
    }

    public static Cliente cliente1() {
        return new Cliente(1L, "12345678A", "Ana", "ana@email.com", "600111111", "Madrid", "España", true);
    }

    public static Cliente cliente2() {
        return new Cliente(2L, "23456789B", "Luis", "luis@email.com", "600222222", "Sevilla", "España", false);
    }

    public static Producto producto1() {
        return new Producto(1L, "P001", "Teclado", "Informatica", 25.5, 10, true);
    }

    public static Producto producto2() {
        return new Producto(2L, "P002", "Ratón", "Informatica", 12.99, 30, true);
    }

    public static Proveedor proveedor1() {
        return new Proveedor(1L, "PR001", "Distribuciones Sur", "Marta Ruiz", "marta@proveedor.com", "España");
    }

    public static Proveedor proveedor2() {
        return new Proveedor(2L, "PR002", "Global Tech", "John Smith", "john@globaltech.com", "Portugal");
    }

    public static Inventario inventario1() {
        return new Inventario(1L, 1L, 1L, "A1", 8, 5, "2026-04-01");
    }

    public static Inventario inventario2() {
        return new Inventario(2L, 2L, 2L, "B2", 3, 10, "2026-04-02");
    }

    public static Pedido pedido1() {
        return new Pedido(1L, "PD001", 1L, "2026-04-01", "PAGADO", 38.49);
    }

    public static Pedido pedido2() {
        return new Pedido(2L, "PD002", 2L, "2026-04-02", "ENVIADO", 199.90);
    }

    public static LineaPedido linea1() {
        return new LineaPedido(1L, 1L, 1L, 1, 25.50, 25.50);
    }

    public static LineaPedido linea2() {
        return new LineaPedido(2L, 1L, 2L, 1, 12.99, 12.99);
    }
}
