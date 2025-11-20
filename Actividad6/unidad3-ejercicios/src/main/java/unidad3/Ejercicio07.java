package unidad3;

import java.util.List;


public class Ejercicio07 {

    public static class ParesImpares {
        private final List<Integer> pares;
        private final List<Integer> impares;

        public ParesImpares(List<Integer> pares, List<Integer> impares) {
            this.pares = pares;
            this.impares = impares;
        }

        public List<Integer> getPares() {
            return pares;
        }

        public List<Integer> getImpares() {
            return impares;
        }
    }


    public static ParesImpares calcularParesImpares(int a, int b) {
        for (int i = 0; i < b; i++) {
            if(a > b){
                
            }
        }
        return new ParesImpares(null, null);
    }
}
