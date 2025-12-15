package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> Agenda;

    /**
     * Constructor por defecto
     * @param agenda Lista de contactos
     */
    public Agenda(List<Contacto> agenda) {
        Agenda = agenda;
    }

    public List<Contacto> getAgenda() {
        return Agenda;
    }

    public void setAgenda(List<Contacto> agenda) {
        Agenda = agenda;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Agenda == null) ? 0 : Agenda.hashCode());
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
        Agenda other = (Agenda) obj;
        if (Agenda == null) {
            if (other.Agenda != null)
                return false;
        } else if (!Agenda.equals(other.Agenda))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Agenda [Agenda=" + Agenda + "]";
    }

    /**
     * Metodo que borra un telefono por su tipo
     * @param tipo tipo de telefono que se borra
     */
    public void borrarTelefonoPorTipo(String tipo){

        for (Contacto contacto : Agenda) {
            contacto.getTelefonos().removeIf(telefono -> telefono.getTipo().equals(tipo));
        }
    }

    /**
     * Metodo que busca un contacto por su nombre
     * @param nombre nombre del contacto
     * @return el contacto
     */
    public Contacto buscarContactoPorNombre(String nombre){

        for (Contacto contacto : Agenda) {
            if(contacto.getNombre().equals(nombre)){
                return contacto;
            }
        }
        throw new IllegalArgumentException("El contacto no existe");
    }

    /**
     * Metodo que busca un contacto por un numero de telefono
     * @param numero el numero de telefono
     * @return el contacto
     */
    public Contacto buscarContactoPorNumero(String numero){

        List<Telefono> listaTelefonos = new ArrayList<>();
        for (int i = 0; i < Agenda.size(); i++) {
            listaTelefonos = Agenda.get(i).getTelefonos();
            if(listaTelefonos.get(i).getNumero().equals(numero)){
                return Agenda.get(i);
            }
        }
        throw new IllegalArgumentException("El contacto no existe");
    }   
}
