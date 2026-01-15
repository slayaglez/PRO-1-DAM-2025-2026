package com.docencia.notifica;

public abstract class Notificacion implements INotificacion{

    private final String destino;

    public Notificacion(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }
    
}
