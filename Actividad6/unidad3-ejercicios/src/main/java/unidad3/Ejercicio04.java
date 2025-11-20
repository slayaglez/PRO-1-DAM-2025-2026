package unidad3;


public class Ejercicio04 {

    public static class ContadorSignos {
        private int positivos;
        private int negativos;
        private int ceros;

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

        public void setPositivos(int positivos) {
            this.positivos = positivos;
        }

        public void setNegativos(int negativos) {
            this.negativos = negativos;
        }

        public void setCeros(int ceros) {
            this.ceros = ceros;
        }

        
    }

    
    public static ContadorSignos contarSignos(int[] numeros) {
        if(numeros==null){
            return  new ContadorSignos(0, 0, 0);
        }
        int negativo=0, positivo=0, cero=0;
        for (int numero : numeros) {
            if(numero < 0){
                negativo++;
            }
            if(numero == 0){
                cero++;
            }
            if(numero > 0){
                positivo++;
            }
        }
        return  new ContadorSignos(positivo, negativo, cero);
    }
}
