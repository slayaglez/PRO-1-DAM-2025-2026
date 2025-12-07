package com.docencia.composicion.ejercicio15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que idea un carrito de la compra con productos que se pueden
 * agregar, eliminar, buscar por id o contarlos por nombre
 */
public class Ejercicio15 {

    public static void main(String[] args) {
        Producto producto1 = new Producto("1234", "cafe", 4.99);
        Producto producto2 = new Producto("3456", "cereales", 3.99);
        Producto producto3 = new Producto("4729", "agua", 1.99);
        Producto producto4 = new Producto("8642", "arroz", 2.99);
        Producto producto5 = new Producto("0974", "fruta", 5.99);

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        Carrito carrito1 = new Carrito(productos);
        System.out.println("\n");
        System.out.println(carrito1);

        Producto producto6 = new Producto("4758", "refresco", 2.50);
        carrito1.agregarCarrito(producto6);
        System.out.println("\n");
        System.out.println(carrito1);

        carrito1 = eliminarPorId(carrito1, "1234");
        System.out.println("\n");
        System.out.println(carrito1);

        productos.add(producto2);
        productos.add(producto2);
        Carrito carrito2 = new Carrito(productos);
        System.out.println("\n");
        System.out.println("Hay "+ contarTotalPorNombre(carrito2, "cereales") + " unidades de cereal");

    }

    /**
     * Elimina un producto del carrito por su id
     * @param carrito el carrito
     * @param id el id del producto a eliminar
     * @return un carrito sin el producto
     */
    public static Carrito eliminarPorId(Carrito carrito, String id){

        List<Producto> productosResultado = new ArrayList<>();

        for (Producto producto : carrito.getProductos()) {
            if(!(producto.getId().equals(id))){
                productosResultado.add(producto);
            }
        }
        Carrito resultado = new Carrito(productosResultado);
        return resultado;
    }

    /**
     * Calcula el precio total de un carrito
     * @param carrito el carrito 
     * @return double del precio total
     */
    public static double calcularTotal(Carrito carrito){
        double total=0;
        for (Producto producto : carrito.getProductos()) {
            total += producto.getPrecio();
        }
        return total;
    } 

    /**
     * Cuenta el total de productos del mismo nombre
     * en un carrito
     * @param carrito el carrito
     * @param nombre el nombre del producto a contar
     * @return numero de veces que esta el producto en el carrito
     */
    public static int contarTotalPorNombre(Carrito carrito, String nombre){
        int total=0;
        for (Producto producto : carrito.getProductos()) {
            if(producto.getName().equals(nombre)){
            total++;
            }
        }
        return total;
    }
}
