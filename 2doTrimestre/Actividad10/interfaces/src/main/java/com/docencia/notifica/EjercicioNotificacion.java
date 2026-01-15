package com.docencia.notifica;

public class EjercicioNotificacion {

    public static void enviar(INotificacion notificacion) {
        notificacion.enviar();
    }

    public static void main(String[] args) {
        INotificacion notiEmail = new Email("sebastianlaya01@gmail.com", "Que pasa", "Vente a mi casa");
        INotificacion notiSms = new Sms("6169667777", "Tu código es 9898");
        enviar(notiEmail);
        enviar(notiSms);
    }
}
