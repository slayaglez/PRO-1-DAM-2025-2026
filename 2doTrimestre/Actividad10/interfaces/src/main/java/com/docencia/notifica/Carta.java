package com.docencia.notifica;

public class Carta extends Notificacion{

    private final String poema;

    public Carta(String destino, String poema) {
        super(destino);
        this.poema = poema;
    }

    @Override
    public String destino() {
        return getDestino();
    }

    @Override
    public String mensaje() {
        return poema;
    }

    @Override
    public void enviar() {
        System.out.println("Soy un envío por carta");
    }

}
