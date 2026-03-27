package com.docente.validacion;

public class Validaciones {

    public static boolean esIdentificadorValido(String identificador) {
        return esCadenaNoNula(identificador);
    }

    private static boolean esCadenaNoNula(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }

    public static boolean esNombreValido(String nombre) {
        return esCadenaNoNula(nombre);
    }

    public static boolean esCursoValido(String curso) {
        return esCadenaNoNula(curso);
    }

    public static boolean esEdadValida(int edad) {
        return edad >= 17 && edad < 100;
    }

    public static boolean esCodigoAsignaturaValido(String codigo) {
        return codigo != null && !codigo.trim().isEmpty();
    }

    public static boolean esHorasSemanalesValidas(int horas) {
        return horas > 0;
    }
}
