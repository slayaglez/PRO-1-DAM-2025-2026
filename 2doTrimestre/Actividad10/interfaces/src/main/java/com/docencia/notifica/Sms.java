package com.docencia.notifica;

public class Sms extends Notificacion{

    private final String texto;

    /**
     * Constructor por defecto clase SMS
     * @param destino destino del sms
     * @param texto texto del sms
     */
    public Sms(String destino, String texto) {
        super(destino);
        this.texto = texto;
    }

    @Override
    public String destino() {
        return getDestino();
    }

    @Override
    public String mensaje() {
        return texto;
    }

    @Override
    public void enviar() {
        System.out.println("Enviando SMS a " + destino() + "-->" + mensaje());
    }


}
