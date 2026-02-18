package com.docencia.expresiones.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;


public final class Ejercicio2Test {

        // 1) http válido
    @Test
    void urlValida_httpBasica_true() {
        assertTrue(Ejercicio2.esUrlHttpValida("http://midominio.com"));
    }

    // 2) https válido
    @Test
    void urlValida_httpsBasica_true() {
        assertTrue(Ejercicio2.esUrlHttpValida("https://midominio.com"));
    }

    // 3) subdominio válido
    @Test
    void urlValida_conSubdominio_true() {
        assertTrue(Ejercicio2.esUrlHttpValida("https://api.midominio.com"));
    }

    // 4) ruta válida
    @Test
    void urlValida_conRuta_true() {
        assertTrue(Ejercicio2.esUrlHttpValida("https://midominio.com/api/test"));
    }

    // 5) ruta solo / válida
    @Test
    void urlValida_conBarraFinal_true() {
        assertTrue(Ejercicio2.esUrlHttpValida("https://midominio.com/"));
    }

    // 6) protocolo no permitido
    @Test
    void urlInvalida_protocoloFtp_false() {
        assertFalse(Ejercicio2.esUrlHttpValida("ftp://midominio.com"));
    }

    // 7) sin protocolo
    @Test
    void urlInvalida_sinProtocolo_false() {
        assertFalse(Ejercicio2.esUrlHttpValida("midominio.com"));
    }

    // 8) sin TLD
    @Test
    void urlInvalida_sinTld_false() {
        assertFalse(Ejercicio2.esUrlHttpValida("https://midominio"));
    }

    // 9) TLD numérico (no permitido)
    @Test
    void urlInvalida_tldNumerico_false() {
        assertFalse(Ejercicio2.esUrlHttpValida("https://midominio.123"));
    }

    // 10) null debe devolver false
    @Test
    void urlNull_false() {
        assertFalse(Ejercicio2.esUrlHttpValida(null));
    }

}
