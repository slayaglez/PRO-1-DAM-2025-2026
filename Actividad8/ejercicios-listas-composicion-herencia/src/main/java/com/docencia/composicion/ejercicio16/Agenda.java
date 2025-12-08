package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> Agenda;

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

    //! Esto es una castaña, usa el remove() y el contains()
    public Agenda borrarTelefonoPorTipo(Agenda agenda, String tipo){
        
        List<Telefono> telefonos2 = new ArrayList<>();
        Contacto contacto2 = new Contacto(null, null);
        List<Contacto> contactos = new ArrayList<>();
        contactos = agenda.getAgenda();
        String nombre="";
        List<Contacto> contactos2 = new ArrayList<>();

        for (Contacto contacto : agenda.getAgenda()) {
            List<Telefono> telefonos = contacto.getTelefonos();
            for (int i = 0; i < telefonos.size(); i++) {
                if(!(telefonos.get(i).getTipo().equals(tipo))){
                    contacto2.agregarTelefono(telefonos.get(i)); //! Rompe aqui
                    nombre = getContactoPorIndex(contactos, i).getNombre();
                    contacto2.setNombre(nombre);
                }
            }
            contactos2.add(contacto2);
        }
        Agenda resultado = new Agenda(contactos2);
        return resultado;
    }

    public Contacto getContactoPorIndex(List<Contacto> contactos, int index){

        Contacto resultado = new Contacto();
        resultado = contactos.get(index);
        
        return resultado;
    }
    
}
