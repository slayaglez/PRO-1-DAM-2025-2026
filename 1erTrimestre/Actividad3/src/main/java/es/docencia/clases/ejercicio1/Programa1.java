package es.docencia.clases.ejercicio1;

public class Programa1 {

        public static void main(String[] args) {
            Persona1 persona1 = new Persona1("Caín", 127);
            
            Persona1 persona2 = new Persona1("Abel", 100);

            Persona1 persona3 = new Persona1("Abel", 100);
            if(persona1.equals(persona2)){
                System.out.println("Somos la misma persona");
            }
            
        }
}
