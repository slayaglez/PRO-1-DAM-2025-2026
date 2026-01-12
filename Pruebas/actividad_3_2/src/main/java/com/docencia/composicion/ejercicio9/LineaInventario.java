/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa de clases para manejar un inventario pudiendo aniadir y retirar stock
 */
package com.docencia.composicion.ejercicio9;

public class LineaInventario {
    private final Producto producto;
    private int cantidad;

    /**
     * Constructor por defecto
     * @param producto Producto
     * @param cantidad cantidad en el stock
     */
    public LineaInventario(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
