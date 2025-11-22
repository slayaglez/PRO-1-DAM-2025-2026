package org.docencia.unidad3.examen.ejercicio02;

import java.util.Objects;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que opera con arrays de numeros calculando sus medias, 
 * tamanios, maximos y minimos ademas de la funcion operar que opera con
 * dos variables.
 * 
 */

public class CalculadoraEstadistica {

    /**
     * Funcion que opera con dos variables en base la opcion elegida
     * (suma, resta, multiplicacion o division)
     * @param a variable a
     * @param b variable b
     * @param opcion eleccion
     * @return resultado de la operacion
     */
    public double operar(double a, double b, int opcion) {
        switch(opcion) {
            case 1: return a+b;
            case 2: return a-b;
            case 3: return a*b;
            case 4: 
                if(b==0){
                    throw new ArithmeticException();
                }
                return a/b;
            default: throw new IllegalArgumentException();
        }
    }

    /**
     * Funcion que pasado un array calcula el tamanio, el minimo, el maximo
     * y la media de todos ellos
     * @param numeros array de numeros double
     * @return dato tipo Estadistica que tiene (cantidad, media, maximo y minimo)
     */
    public Estadisticas calcularEstadisticas(double[] numeros) {

        if(numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException();
        }

        int cantidad=numeros.length;
        double media=numeros[0];
        double maximo=numeros[0];
        double minimo=numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            media += numeros[i];
            if(maximo < numeros[i]){
                maximo = numeros[i];
            }
            if(minimo > numeros[i]){
                minimo = numeros[i];
            }
        }
        media /= cantidad;
        Estadisticas resultado = new Estadisticas(cantidad, media, maximo, minimo);
        return resultado;
    }

    
    public static class Estadisticas {
        private final int cantidad;
        private final double media;
        private final double maximo;
        private final double minimo;

        /**
         * Constructor por defecto
         * @param cantidad tamanio del array
         * @param media media de los numeros del array
         * @param maximo mayor numero
         * @param minimo menor numero
         */
        public Estadisticas(int cantidad, double media, double maximo, double minimo) {
            this.cantidad = cantidad;
            this.media = media;
            this.maximo = maximo;
            this.minimo = minimo;
        }

        public int getCantidad() {
            return cantidad;
        }

        public double getMedia() {
            return media;
        }

        public double getMaximo() {
            return maximo;
        }

        public double getMinimo() {
            return minimo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cantidad, media, maximo, minimo);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Estadisticas other = (Estadisticas) obj;
            return cantidad == other.cantidad && Double.doubleToLongBits(media) == Double.doubleToLongBits(other.media)
                    && Double.doubleToLongBits(maximo) == Double.doubleToLongBits(other.maximo)
                    && Double.doubleToLongBits(minimo) == Double.doubleToLongBits(other.minimo);
        }

        @Override
        public String toString() {
            return "Estadisticas [cantidad=" + cantidad + ", media=" + media + ", maximo=" + maximo + ", minimo="
                    + minimo + "]";
        }
    }
}
