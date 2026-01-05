/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Composicion
 */
package com.docencia.composicion.ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class BandejaMensajes {
    private final List<Mensaje> mensajes = new ArrayList<>();

    /**
     * Envia un mensaje
     * @param remitente quien lo manda
     * @param destinatario quien lo recibe
     * @param texto cuerpo del mensaje
     */
    public void enviarMensaje(String remitente, String destinatario, String texto) {

        if (remitente != null && !(remitente.isBlank()) && destinatario != null && !(destinatario.isBlank())
                && texto != null) {
            mensajes.add(new Mensaje(remitente, destinatario, texto));
        }
    }

    /**
     * Devuelve lista de mensajes segun destinatario
     * @param destinatario quien recibe el mensaje
     * @return lista de mensajes
     */
    public List<Mensaje> mensajesPara(String destinatario) {
        // TODO: devolver solo mensajes dirigidos al destinatario indicado
        // (case-insensitive).

        if (destinatario != null && !(destinatario.isBlank())) {
            List<Mensaje> resultado = new ArrayList<>();
            for (int i = 0; i < mensajes.size(); i++) {
                if (destinatario.trim().toLowerCase().equals(mensajes.get(i).getDestinatario().trim().toLowerCase())) {
                    resultado.add(mensajes.get(i));
                }
            }
            return resultado;
        }
        return new ArrayList<>();
    }

    public List<Mensaje> getMensajes() {
        return new ArrayList<>(mensajes);
    }
}
