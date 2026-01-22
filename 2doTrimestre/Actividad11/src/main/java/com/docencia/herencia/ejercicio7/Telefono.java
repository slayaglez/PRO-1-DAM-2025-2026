/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio7;

import java.util.UUID;

public class Telefono extends Dispositivo {

    private String numero;

    public Telefono(UUID id, String fabricante, String numero) {
        super(id, fabricante);
        this.numero = numero;
}

    public String getNumero() { return numero; }

    @Override
    public String tipo() {
        return "Telefono";
    }

    @Override
    public String toString() {
        return "Telefono [numero=" + numero + "]" + "id="+getId();
    }

    
}
