/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase con herencias e interfaces que trabaja con distintos
 * juegos de mesa y arcade.
 */
package com.docencia.examen.herencia;

import com.docencia.examen.interfaces.TarificableJuego;

public class Arcade extends Juego implements TarificableJuego {

    /**
     * Constructor vacio
     */
    public Arcade() { super(); }

    /**
     * Constructor por defecto
     * @param id identificador
     * @param titulo titulo del juego
     * @param complemento porcentaje de precio extra
     */
    public Arcade(String id, String titulo, double complemento) {
        super(id, titulo, complemento);
    }


    /**
     * Metodo que devuelve el tipo de juego
     */
    @Override
    public String tipoJuego() {
        return "ARCADE";
    }

    /**
     * Metodo que devuelve el precio mas su complemento
     */
    @Override
    public double precio() {
        return 20 + (20*super.getComplement()/100);
    }

    @Override
    public double getComplemento() {
        return complemento;
    }
}
