package es.docencia.clases.ejercicio3;

import java.util.Arrays;

public class Miclase {

    static String miValor;

    public static void main(String[] args) {
        miValor = "Esto Es uN Valor";
        System.out.println("Hola, "+miValor.toLowerCase());
        System.out.println("HOLAAA, "+miValor.toUpperCase());
        // Muestra un txt si empieza por e/E
        if(miValor.startsWith("e") || miValor.startsWith("E")){
            System.out.println("El valor empieza por 'E'");
        }
        miValor = "2";
        Integer valorEnEntero = Integer.parseInt(miValor);
        miValor = "Esto Es uN Valor";
        String valorSinEspacios = miValor.replaceAll(" ", "");

        System.out.println("Valor sin espacios: "+valorSinEspacios);
        System.out.println("Índice del valor 'o': "+miValor.indexOf("o"));
        String[] miArray = miValor.split(" ");
        System.out.println(Arrays.toString(miArray));

        String[] soyUnArray = {"elemento1", "elemento2", "elemento3"};
        String union = String.join(" ", soyUnArray);
        System.out.println("Valor del array unificado: "+union);
    }
}
