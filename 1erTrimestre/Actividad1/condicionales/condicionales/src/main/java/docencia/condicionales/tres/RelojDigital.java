package docencia.condicionales.tres;
import java.time.LocalDateTime;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que saluda en base a la hora local
 * 
 */
public class RelojDigital {
    public static void main(String[] args) {
        
        // Pido la hora con LocalDateTime
        LocalDateTime locaDate = LocalDateTime.now();
        // Guardo solo la hora
        int hora  = locaDate.getHour();

        // Saludo según la hora
        if(hora <= 11 && hora >= 6){
            System.out.println("Buenos Días");
        } else if(hora <= 19 && hora >= 12) {
            System.out.println("Buenas tardes");
        } else if((hora <= 23 && hora >= 20) || (hora <= 5 && hora >= 0)) {
            System.out.println("Buenas noches");
        } else {
            System.out.println("Estamos en el fin del mundo o tu reloj local falla");
        }
    }
}
