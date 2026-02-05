/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una palabra repetida
 */
package com.docencia.expresiones.ejercicio6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 6) DETECTAR PALABRA REPETIDA CONSECUTIVA - Detectar si existe una palabra
 * repetida inmediatamente (ej: "hola hola"), usando grupos y backreferences.
 * Válidos: "hola hola", "qué qué", "test test" Inválidos: "hola adiós hola",
 * "holahola", "hola adiós"
 */
public class Ejercicio06 {

    /**
     * Devuelve true si existe al menos una palabra repetida consecutivamente.
     */
    public static boolean hasConsecutiveRepeatedWord(String text) {
    if (text == null || text.isBlank()) {
        return false;
    }
    
    //? Uso \\b para marcarle al matcher el principio y final de la expresion
    //? OJO no es lo mismo que ^ y $

    String regex = "\\b([a-zA-Záéíóú]+)\\s+\\1\\b";
    
    //? Uso Pattern.CASE_INSENSITIVE... para decirle al matcher que compare igual entre mayusculas
    //? minusculas y caracteres UNICODE como é (no pude encontrar otra forma) (te pasaste Joatham)
    //? Aqui esta la documentacion de donde saque esto, NO USE IA
    //? https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#CASE_INSENSITIVE
    //? https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html#UNICODE_CHARACTER_CLASS

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);
    
    Matcher matcher = pattern.matcher(text);
    
    //? Debo usar find() porque matches() compara toda la cadena y 
    //? no busca una coincidencia dentro de una cadena
    return matcher.find(); 
}
}
