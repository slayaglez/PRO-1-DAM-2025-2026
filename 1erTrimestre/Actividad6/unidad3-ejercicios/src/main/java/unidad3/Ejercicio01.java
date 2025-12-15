package unidad3;


public class Ejercicio01 {
    
    public Ejercicio01(){}

    public static String calificar(int nota) {

        if(nota >= 0 && nota < 5){
            return "Insuficiente";
        }
        if(nota >= 5 && nota < 6){
            return "Suficiente";
        }
        if(nota >= 6 && nota < 7){
            return "Bien";
        }
        if(nota >= 7 && nota < 9){
            return "Notable";
        }
        if(nota >= 9 && nota <= 10){
            return "Sobresaliente";
        }
        throw new IllegalArgumentException();
    }
}
