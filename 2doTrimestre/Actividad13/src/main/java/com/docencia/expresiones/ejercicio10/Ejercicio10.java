/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Dios mio socorro
 */
package com.docencia.expresiones.ejercicio10;

/**
 /**
 * 10) VALIDAR DNI/NIF ESPAÑOL (8 dígitos + letra) EXACTO
 *    - Validar un DNI/NIF con este formato:
 *      8 dígitos (sin separadores) + 1 letra (mayúscula)
 *    - Reglas:
 *      1) Debe ser EXACTAMENTE: ^\d{8}[A-Z]$
 *      2) Además, la letra debe corresponder al número:
 *         letra = "TRWAGMYFPDXBNJZSQVHLCKE"[numero % 23]
 *
 *    Válidos (si la letra cuadra):
 *      "00000000T", "12345678Z", "53077918Y"
 *
 *    Inválidos:
 *      - Formato incorrecto: "1234567Z", "12345678-z", "12.345.678Z"
 *      - Letra incorrecta:   "12345678A"
 *
 */
public class Ejercicio10 {

    public static boolean validarDNI(String dni) {
    //! ????????????????????????????????????????????????????????????????????????????????????????????????????????????

    if (dni == null) {
        return false;
    }
    
    String patron = "^\\d{8}[A-Z]$";
    if (!dni.matches(patron)) {
        return false;
    }

    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    //? substring() devuelve la cadena que se encuentre entre las posiciones dadas
    int numero = Integer.parseInt(dni.substring(0, 8)); 
    char letraProporcionada = dni.charAt(8);
    char letraCorrecta = letras.charAt(numero % 23);
    
    return letraProporcionada == letraCorrecta;
    }

}

