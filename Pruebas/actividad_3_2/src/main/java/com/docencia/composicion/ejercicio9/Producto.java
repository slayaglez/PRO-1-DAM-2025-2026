/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa de clases para manejar un inventario pudiendo aniadir y retirar stock
 */
package com.docencia.composicion.ejercicio9;

public class Producto {
    private final String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
