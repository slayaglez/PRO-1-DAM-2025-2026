package unidad3;

/**
 * Ejercicio 9: Estadísticas de una serie de números.
 */
public class Ejercicio09 {

    /**
     * Clase auxiliar con las estadísticas calculadas.
     */
    public static class Estadisticas {
        private final int cantidad;
        private final double media;
        private final int maximo;
        private final int minimo;

        public Estadisticas(int cantidad, double media, int maximo, int minimo) {
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

        public int getMaximo() {
            return maximo;
        }

        public int getMinimo() {
            return minimo;
        }
    }

    public static Estadisticas calcularEstadisticas(int[] numeros) {
        
        if(numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException();
        }

        double media = numeros[0];
        int maximo = numeros[0];
        int minimo = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            //media
            media += numeros[i];

            //maximo
            if(maximo < numeros[i]){
                maximo = numeros[i];
            }

            //minimo
            if(minimo > numeros[i]){
                minimo = numeros[i];
            }
        }
        media /= numeros.length;
        

        return new Estadisticas(numeros.length, media, maximo, minimo);
    }
}
