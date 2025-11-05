package com.docencia.programacion;

public class Ejercicio14 {
    private final double[] grades;

    /**
     * Constructor por defecto
     */
    public Ejercicio14(){
        this.grades = new double[0];
    }

    /**
     * Constructor con un array como parametro
     * @param grades
     */
    public Ejercicio14(double[] grades) {
        this.grades = grades;
    }

    /**
     * Funcion que devuelve el mayor valor de un array
     * @return El double de mayor valor
     */
    public double getMaxGrade() {
        if (grades == null || grades.length < 1) {
            return 0.0d;
        }
        double maxNumero=grades[1];
        for (double numero : grades) { 
            if (numero > maxNumero) {
                maxNumero = numero;
            }
        }
        return maxNumero;
    }

    /**
     * Funcion que devuelve el menor valor de un array
     * @return El double de menor valor
     */
    public double getMinGrade() {
        if (grades == null || grades.length < 1) {
            return 0.0d;
        }
        double minNumero=grades[1];
        for (double numero : grades) { 
            if (numero < minNumero) {
                minNumero = numero;
            }
        }
        return minNumero;
    }

    /**
     * Funcion que devuelve la media de los numeros de un array
     * @return double, media de los numeros de un array
     */
    public double getAverageGrade() {
        double media=0.0d;
        for (double numero : grades) {
            media += numero;
        }
        media = media/grades.length;
        return media;
    }
}
