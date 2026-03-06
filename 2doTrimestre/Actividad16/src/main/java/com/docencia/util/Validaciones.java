package com.docencia.util;

import java.util.regex.Pattern;

public class Validaciones {
    

    /**
     * Metodo que normaliza un email
     * @param email el email
     * @return el email normalizado
     */
    public static String normalizarEmail(String email){

        if(email == null || email.isBlank()){
            return null;
        }
        return email.trim().toLowerCase();
    }

    public static boolean emailValido(String email){

        String normalizado = normalizarEmail(email);
        
        if(normalizado == null){
            return false;
        }
        String patron = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        return Pattern.matches(patron, normalizado);
    }   

    public static boolean passwordValida(String password){
        //TODO
        return true;
    }

    public static boolean validarPassword(String password){
        //TODO
        return true;
    }

    public static boolean validarNombre(String nombre){
        //TODO
        return true;
    }

    public static boolean validarEmail(){
        //TODO
        return true;
    }
}
