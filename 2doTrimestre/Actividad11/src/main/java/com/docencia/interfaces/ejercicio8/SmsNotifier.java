/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio8;

import java.util.UUID;

/**
 * Implementacion concreta de Notificable.
 */
public class SmsNotifier implements Notificable {

    private UUID id;
    private String numero;
    private String proveedor;

    public SmsNotifier(UUID id, String numero, String proveedor) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.numero = numero;
        this.proveedor = proveedor;
    }

    public UUID getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getProveedor() {
        return proveedor;
    }

    @Override
    public boolean notificar(String mensaje) {
        return mensaje != null && !mensaje.isBlank() && numero != null && numero.length() >= 6;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SmsNotifier other = (SmsNotifier) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SmsNotifier [id=" + id + ", numero=" + numero + ", proveedor=" + proveedor + "]";
    }

    
}
