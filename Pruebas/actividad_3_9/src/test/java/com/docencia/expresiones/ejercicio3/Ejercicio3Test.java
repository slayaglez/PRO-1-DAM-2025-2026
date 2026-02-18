package com.docencia.expresiones.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public final class Ejercicio3Test {

    
// 1) Caso válido típico
    @Test
    void contrasenaValida_tipica_true() {
        assertTrue(Ejercicio3.esContrasenaFuerteValida("ClaveSegura1!"));
    }

    // 2) Válida, justo 10 caracteres y cumple todo
    @Test
    void contrasenaValida_justoDiez_true() {
        // "Aa1!aaaaaa" -> 10 caracteres, sin espacios, mayus/minus/numero/simbolo
        assertTrue(Ejercicio3.esContrasenaFuerteValida("Aa1!aaaaaa"));
    }

    // 3) Inválida: menos de 10 caracteres
    @Test
    void contrasenaInvalida_menosDeDiez_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("Ab1!cdefg")); // 9
    }

    // 4) Inválida: sin mayúscula
    @Test
    void contrasenaInvalida_sinMayuscula_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("clavesegura1!"));
    }

    // 5) Inválida: sin minúscula
    @Test
    void contrasenaInvalida_sinMinuscula_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("CLAVESEGURA1!"));
    }

    // 6) Inválida: sin número
    @Test
    void contrasenaInvalida_sinNumero_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("ClaveSegura!!"));
    }

    // 7) Inválida: sin símbolo
    @Test
    void contrasenaInvalida_sinSimbolo_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("ClaveSegura12"));
    }

    // 8) Inválida: contiene espacio en medio
    @Test
    void contrasenaInvalida_conEspacioEnMedio_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("Clave Segura1!"));
    }

    // 9) Inválida: contiene espacio al final
    @Test
    void contrasenaInvalida_conEspacioFinal_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida("ClaveSegura1! "));
    }

    // 10) Null -> false
    @Test
    void contrasenaNull_false() {
        assertFalse(Ejercicio3.esContrasenaFuerteValida(null));
    }

   
}
