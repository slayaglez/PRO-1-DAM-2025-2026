package com.docencia.composicion.ejercicio12;
import java.util.ArrayList;
import java.util.List;


/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Un programa que gestiona pedidos y productos 
 * con clases
 * 
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        Producto producto1 = new Producto("pizza", 9.99);
        Producto producto2 = new Producto("silla", 39.99);
        Producto producto3 = new Producto("avion", 999.99);

        LineaPedido linea1 = new LineaPedido(producto1, 3);
        LineaPedido linea2 = new LineaPedido(producto2, 2);

        System.out.println(linea1);

        List<LineaPedido> pedidos1 = new ArrayList<>();
        pedidos1.add(linea1);
        pedidos1.add(linea2);
        System.out.println(pedidos1);

        

        double total = calcularTotal(pedidos1);
        System.out.println(total);
    }

    /**
     * Metodo que calcula el total del precio de los productos de 
     * un pedido
     * @param pedidos lista de LineaPedidos
     * @return double total
     */
    public static double calcularTotal(List<LineaPedido> pedidos){
        
        double total=0;

        for (int i = 0; i < pedidos.size(); i++) {
            LineaPedido linea1 = pedidos.get(i);
            int cantidad = linea1.getCantidad();
            Producto producto = linea1.getProducto();
            double precio = producto.getPrecio();

            total += precio*cantidad;
        }

        return total;
    }
}
