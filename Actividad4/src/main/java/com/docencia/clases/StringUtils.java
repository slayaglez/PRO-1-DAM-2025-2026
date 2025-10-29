package com.docencia.clases;

/**
 * @author slayaglez 
 * @version 1.0.0
 * 
 */
public class StringUtils {

    /**
     * Funcion que normaliza una cadena de texto
     * @param cadena String que se pretende normalizar
     * @return Cadena de texto normal
     */
    public static String normalizaNombre(String cadena) {

        if(cadena == null || cadena.isEmpty()){     //! EXAMEN
            return cadena;
        }

        cadena = cadena.trim();
        cadena = cadena.toLowerCase();

        char primeraLetra = cadena.charAt(0);
        String primeraLetraString = String.valueOf(primeraLetra);
        String primeraLetraMayus = primeraLetraString.toUpperCase();
        cadena = cadena.replaceFirst(primeraLetraString, primeraLetraMayus);
        
        return cadena;
    }

    /**
     //! EXAMEN
     * Funcion que cuenta el numero de vocales y consonantes en una cadena
     * @param cadena String con la cadena de entrada
     * @return Array con el numero de vocales y consonantes
     */
    public static int[] cuentaLetras(String cadena) {
        int[] resultado = new int[2];
        int vocales=0, consonantes=0;

        if(cadena == null || cadena.isEmpty()){
            return resultado;
        }
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            if(letra >= 'a' && letra <= 'z'){
                if(letra =='a' || letra =='e' || letra =='i' || letra =='o' || letra =='u'){
                    vocales++;
                }
                else {
                    consonantes++;
                }
            }
        }
        resultado[0] = vocales;
        resultado[1] = consonantes;

        return resultado;
    }

    /**
     * Funcion que determina si una cadena es palindromo
     * @param cadena String con la cadena de entrada 
     * @return true / false
     */
    public static boolean esPalindromo(String cadena) {
        if(cadena == null || cadena.isEmpty()) {
            return false;
        }
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        cadena = cadena.replaceAll(" ", "");

        for (int i = 0; i < cadena.length()/2; i++) {
            if(cadena.charAt(i)!=cadena.charAt(cadena.length()-i-1)){
                return false;
            }
        }

        return true;
    }

    public static String acronimo(String frase) {
        return null;
    }

    public static void main(String[] args) {
        String resultado1 = normalizaNombre(" aNA ");
        System.out.println("'"+resultado1+"'");

        int[] resultado2 = cuentaLetras("Hola, 123");
        System.out.println("[" + resultado2[0] + ", " + resultado2[1] + "]");

        boolean resultado3 = esPalindromo("Ojo Rojo");
        System.out.println(resultado3);
    }
}