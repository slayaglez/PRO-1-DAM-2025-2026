package org.docencia.unidad3.examen.ejercicio04;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con arrays enteros, cuenta sus positivos, 
 * negativos y ceros; devuelve sus pares e impares en listas y cuenta 
 * la cantidad de numeros primos.
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnalizadorNumerico {

    /**
     * Funcion que cuenta los signos
     * 
     * @param numeros array de enteros
     * @return numero de positivos, negativos y ceros
     */
    public ContadorSignos contarSignos(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException();
        }
        if (numeros.length == 0) {
            return new ContadorSignos(0, 0, 0);
        }
        int negativos = 0;
        int positivos = 0;
        int ceros = 0;
        for (int numero : numeros) {
            if (numero < 0) {
                negativos++;
            }
            if (numero > 0) {
                positivos++;
            }
            if (numero == 0) {
                ceros++;
            }
        }
        ContadorSignos resultado = new ContadorSignos(positivos, negativos, ceros);
        return resultado;
    }

    /**
     * Funcion que devuelve los numeros pares y los impares en cierto rango
     * 
     * @param a inicio del rango
     * @param b fin del rango
     * @return lista con los numeros pares y lista con los impares
     */
    public ParesImpares calcularParesImpares(int a, int b) {
        List pares = new ArrayList<>();
        List impares = new ArrayList<>();
        if (a > b) {
            int aux = a;
            a = b;
            b = aux;
        }
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                pares.add(i);
            }
            if (i % 2 != 0) {
                impares.add(i);
            }

        }
        ParesImpares resultado = new ParesImpares(pares, impares);
        return resultado;
    }

    /**
     * Funcion que devuelve la cantidad de numeros primos en un rango dado
     * @param a inicio del rango
     * @param b fin del rango
     * @return cantidad de primos
     */
    public int contarPrimos(int a, int b) {

        int primos=0;
        boolean esPrimo=true;
        if (a > b) {
            int aux = a;
            a = b;
            b = aux;
        }
        for (int i = a; i <= b; i++) {
            for (int j = 2; j*j <= i; j++) {
                if(i%j==0) {
                    esPrimo=false;
                }
            }
            if(esPrimo && i>1){
                primos++;
            }
            esPrimo=true;
            
        }
        return primos;
    }

    public static class ContadorSignos {
        private final int positivos;
        private final int negativos;
        private final int ceros;

        /**
         * Constructor por defecto
         * @param positivos cantidad de positivos
         * @param negativos cantidad de negativos
         * @param ceros cantidad de ceros
         */
        public ContadorSignos(int positivos, int negativos, int ceros) {
            this.positivos = positivos;
            this.negativos = negativos;
            this.ceros = ceros;
        }

        public int getPositivos() {
            return positivos;
        }

        public int getNegativos() {
            return negativos;
        }

        public int getCeros() {
            return ceros;
        }

        @Override
        public int hashCode() {
            return Objects.hash(positivos, negativos, ceros);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ContadorSignos other = (ContadorSignos) obj;
            return positivos == other.positivos && negativos == other.negativos && ceros == other.ceros;
        }

        @Override
        public String toString() {
            return "ContadorSignos [positivos=" + positivos + ", negativos=" + negativos + ", ceros=" + ceros + "]";
        }

    }

    public static class ParesImpares {
        private final List<Integer> pares;
        private final List<Integer> impares;

        /**
         * Constructor por defecto
         * @param pares lista de numeros pares
         * @param impares lista de numeros impares
         */
        public ParesImpares(List<Integer> pares, List<Integer> impares) {
            this.pares = new ArrayList<>(pares);
            this.impares = new ArrayList<>(impares);
        }

        public List<Integer> getPares() {
            return pares;
        }

        public List<Integer> getImpares() {
            return impares;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pares, impares);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ParesImpares other = (ParesImpares) obj;
            return Objects.equals(pares, other.pares) && Objects.equals(impares, other.impares);
        }

    }
}
