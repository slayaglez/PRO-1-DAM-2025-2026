/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio10;

/**
 * Define objetos capaces de dibujarse (representacion textual).
 * <p>
 * Incluye un metodo abstracto y un metodo <i>default</i> para poder probar la interfaz.
 */
public interface Drawable {

    /** Metodo principal de la interfaz. */
    String dibujar();

    /**
     * Metodo default: las interfaces pueden contener implementacion.
     */
    default String info() {
        return "Interfaz Drawable";
    }
}
