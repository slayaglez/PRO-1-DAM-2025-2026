package com.docencia.notifica;

public interface INotificacion {

    /**
     * Funcion que retorna el destinatario
     * @return String
     */
    String destino(); 

    /**
     * Funcion que retorna el mensaje 
     * @return String
     */
    String mensaje();

    /**
     * Funcion que envia la notificacion
     */
    void enviar();


}
