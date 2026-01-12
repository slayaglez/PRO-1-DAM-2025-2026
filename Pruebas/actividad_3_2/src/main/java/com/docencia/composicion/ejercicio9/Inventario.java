/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa de clases para manejar un inventario pudiendo aniadir y retirar stock
 */
package com.docencia.composicion.ejercicio9;


import java.util.ArrayList;
import java.util.List;


public class Inventario {
    private final List<LineaInventario> lineas = new ArrayList<>();

    /**
     * Funcion que aniade stock de cierto producto
     * @param nombreProducto el nombre del producto
     * @param cantidad la cantidad a aniadir
     */
    public void anadirStock(String nombreProducto, int cantidad) {
        if(nombreProducto == null || nombreProducto.isBlank() || cantidad <= 0){
            return;
        }

        for (int i = 0; i < lineas.size(); i++) {
            if(lineas.get(i).getProducto().getNombre().trim().equalsIgnoreCase(nombreProducto)){
                int cantidadInicial = lineas.get(i).getCantidad();
                cantidad += cantidadInicial;
                lineas.get(i).setCantidad(cantidad);
            }
        }
        lineas.add(new LineaInventario(new Producto(nombreProducto.trim().toLowerCase()), cantidad));
    }

    /**
     * Funcion que retira cantidad de producto segun su nombre
     * @param nombreProducto el nombre del producto
     * @param cantidad la cantidad a retirar
     * @return verdadero o falso
     */
    public boolean retirarStock(String nombreProducto, int cantidad) {
        boolean hayStock = false;
        if(nombreProducto == null || nombreProducto.isBlank() || cantidad == 0){
            return false;
        }
        for (int i = 0; i < lineas.size(); i++) {
            if(lineas.get(i).getProducto().getNombre().trim().toLowerCase().equals(nombreProducto.trim().toLowerCase()) && lineas.get(i).getCantidad() >= cantidad){
                int cantidadInicial = lineas.get(i).getCantidad();
                cantidadInicial -= cantidad;
                lineas.get(i).setCantidad(cantidadInicial);
                hayStock = true;
            }
        }
        if(hayStock == true){
            return true;
        }
        return false;
    }

    /**
     * Devuelve la cantidad de producto que hay en stock
     * @param nombreProducto el nombre del producto
     * @return la cantidad que hay en stock (entero)
     */
    public int stockDe(String nombreProducto) {
        if(nombreProducto == null){
            return 0;
        }
        for (int i = 0; i < lineas.size(); i++) {
            if(lineas.get(i).getProducto().getNombre().trim().toLowerCase().equals(nombreProducto.trim().toLowerCase())){
                return lineas.get(i).getCantidad();
            }
        }
        return 0;
    }

    /**
     * Devuelve la cantidad total de todos los productos
     * @return cantidad total de todos los productos (entero)
     */
    public int totalUnidades() {
        int total = 0;
        for (int i = 0; i < lineas.size(); i++) {
            total += lineas.get(i).getCantidad();
        }
                
        return total;
    }

    public List<LineaInventario> getLineas() {
        return new ArrayList<>(lineas);
    }
}
