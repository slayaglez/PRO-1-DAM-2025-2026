/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio7;

/**
 * Define objetos capaces de exportar su informacion.
 * <p>
 * Incluye un metodo abstracto y un metodo <i>default</i> para poder probar la interfaz.
 */
public interface Exportable {

    /** Metodo principal de la interfaz. */
    String exportar();

    /**
     * Metodo default: las interfaces pueden contener implementacion.
     */
    default String info() {
        return "Interfaz Exportable";
    }
}
