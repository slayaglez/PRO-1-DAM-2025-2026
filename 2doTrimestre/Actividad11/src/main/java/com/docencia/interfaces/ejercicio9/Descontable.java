/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio9;

/**
 * Define un descuento aplicable sobre un precio.
 * <p>
 * Incluye un metodo abstracto y un metodo <i>default</i> para poder probar la interfaz.
 */
public interface Descontable {

    /** Metodo principal de la interfaz. */
    double aplicarDescuento(double precio);

    /**
     * Metodo default: las interfaces pueden contener implementacion.
     */
    default String info() {
        return "Interfaz Descontable";
    }
}
