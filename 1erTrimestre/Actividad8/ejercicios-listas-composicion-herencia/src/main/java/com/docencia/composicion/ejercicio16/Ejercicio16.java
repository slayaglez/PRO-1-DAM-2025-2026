package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa de clases con telefonos, contactos y agendas; donde se pueden añadir telefonos
 *  a un contacto, borrar telefonos por su tipo y buscar contactos por nombre o numero
 */
public class Ejercicio16 {

    public static void main(String[] args) {
        Telefono numero1 = new Telefono("fijo", "922996677");
        Telefono numero2 = new Telefono("movil", "618845790");
        Telefono numero3 = new Telefono("movil", "67891234");
        Telefono numero4 = new Telefono("fijo", "922101010");

        List<Telefono> telefonos1 = new ArrayList<>();
        telefonos1.add(numero1);
        telefonos1.add(numero2);
        Contacto contacto1 = new Contacto("Sebas", telefonos1);

        List<Telefono> telefonos2 = new ArrayList<>();
        telefonos2.add(numero3);
        telefonos2.add(numero4);
        Contacto contacto2 = new Contacto("Andrea", telefonos2);

        List<Contacto> contactos = new ArrayList<>();
        contactos.add(contacto1);
        contactos.add(contacto2);
        Agenda agenda = new Agenda(contactos);
        System.out.println("Agenda completa:");
        System.out.println(agenda+"\n");

        contacto1.agregarTelefono(numero3);
        System.out.println("Contacto1 mas un numero:");
        System.out.println(contacto1+"\n");

        
        agenda.borrarTelefonoPorTipo("fijo");
        System.out.println("Agenda menos los fijos:");
        System.out.println(agenda+"\n");

        System.out.println("Contacto buscado por nombre:");
        System.out.println(agenda.buscarContactoPorNombre("Andrea")+"\n");

        System.out.println("Contacto buscado por numero:");
        System.out.println(agenda.buscarContactoPorNumero("618845790"));
    }

    
    

}
