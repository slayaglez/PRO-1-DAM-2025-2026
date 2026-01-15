package com.docencia.notifica;

public class EjercicioNotificacion {

    public static void enviar(Notificacion notificacion) {
        notificacion.enviar();
    }

    public static void main(String[] args) {
        Notificacion notiEmail = new Email("sebastianlaya01@gmail.com", "Que pasa", "Vente a mi casa");
        Notificacion notiSms = new Sms("6169667777", "Tu código es 9898");
        Notificacion notiCarta = new Carta("Calle Tenerife", "Llevo tu olor y tu aroma en tu piel");
        enviar(notiEmail);
        enviar(notiSms);
        enviar(notiCarta);
    }
}
