package com.docencia.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEj {
    public static void main(String[] args) {
        // Crear un ArrayList de Strings
        ArrayList<String> listaDeNombres = new ArrayList<>();

        // Agregar elementos a la lista
        listaDeNombres.add("Juan");
        listaDeNombres.add("María");
        listaDeNombres.add("Carlos");
        listaDeNombres.add(null);

        // Imprimir tamanio
        System.out.println("Tamaño de lista: "+listaDeNombres.size());

        // Imprimir elementos
        System.out.println("Lista de Nombres: " + listaDeNombres);

        // Obtener y modificar un elemento
        String nombre1 = listaDeNombres.get(1);
        String nombre2 = listaDeNombres.get(listaDeNombres.size()-1);
        System.out.println("Nombre en la posición 1: " + nombre1);
        System.out.println("Nombre en la última posición: " + nombre2);

        // Eliminar un elemento
        listaDeNombres.remove("María");
        System.out.println("Lista después de eliminar a María: " + listaDeNombres);

        // Obtener y modificar un elemento
        String nombre3 = listaDeNombres.get(1);
        String nombre4 = listaDeNombres.get(listaDeNombres.size()-1);
        System.out.println("Nombre en la posición 1: " + nombre3);
        System.out.println("Nombre en la última posición: " + nombre4);

        List<Persona> personas = new ArrayList<>();
        
        add(personas, new Persona("4512355B", "Juan"));
        add(personas, new Persona("4849535C", "Carlos"));
        add(personas, new Persona("4596485D", "María"));
        add(personas, new Persona("4596485D", "María"));
        add(personas, null);
        
        System.out.println(personas);

        Persona juan = personas.get(0);
        System.out.println(juan);
        boolean existeJuan = personas.contains(juan);
        System.out.println("¿Existe Juan en la lista? " + existeJuan);

        Persona carmen = new Persona("4565656E", "carmen");
        boolean existeCarmen = personas.contains(carmen);
        System.out.println("¿Existe Carmen en la lista? " + existeCarmen);

        Persona persona1 = new Persona("4512355B");
        boolean existePersona1 = personas.contains(persona1);
        System.out.println("¿Existe Persona uno en la lista? " + existePersona1);

        int posicion = personas.indexOf(persona1);
        System.out.println("Se encuentra en la posición: "+ posicion);

        persona1 = personas.get(posicion);
        System.out.println(persona1);


        System.out.println(personas);
    }

    /**
     * Add an personita
     * @param lista lista de Persona
     * @param persona Persona
     * @return true or false
     */
    public static boolean add(List<Persona> lista, Persona persona){
        
        if (lista == null || persona == null || persona.getId() == null || persona.getId().isBlank()){
            return false;
        }

        int posicion = lista.indexOf(persona);
        if(posicion > -1) {
            return false;
        }
        return lista.add(persona);
    }
}
