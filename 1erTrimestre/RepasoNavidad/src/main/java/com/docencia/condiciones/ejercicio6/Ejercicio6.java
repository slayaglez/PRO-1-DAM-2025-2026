package com.docencia.condiciones.ejercicio6;

public class Ejercicio6 {
    /**
     * Usa switch para devolver días del mes (1-12). Febrero depende de bisiesto.
     */
    public static int diasDelMes(int mes, int anio) {
        // TODO: implementar usando condiciones (if/else) y/o switch según se indica
        switch(mes){
            case 1, 3, 5, 7, 8, 10, 12: return 31;
            case 4, 6, 9, 11: return 30;
            case 2:
                if(anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0 && anio % 100 == 0){
                    return 29;
                }
                else{
                    return 28;
                }
        }
        throw new UnsupportedOperationException("Entrada inválida");
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio6 listo para implementar.");
    }
}
