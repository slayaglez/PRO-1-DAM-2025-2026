package com.docencia.notifica;

public class Email extends Notificacion{

    private final String asunto;
    private final String cuerpo;

    /**
     * Constructor por defecto clase Email
     * @param destino destinatario
     * @param asunto asunto del correo
     * @param cuerpo cuerpo del mensaje
     */
    public Email(String destino, String asunto, String cuerpo){
        super(destino);
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    @Override
    public String destino() {
        return getDestino();
    }

    @Override
    public String mensaje() {
        return asunto + ": " + destino();
    }

    @Override
    public void enviar() {
        System.out.println("Enviando EMAIL a " + getDestino() + "-->" + mensaje());
    }


}
