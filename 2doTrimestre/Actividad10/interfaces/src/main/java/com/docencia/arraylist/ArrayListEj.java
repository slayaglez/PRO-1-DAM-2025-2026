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
        
        personas.add(new Persona("4512355B", "Juan"));
        personas.add(new Persona("4849535C", "Carlos"));
        personas.add(new Persona("4596485D", "María"));
        
        System.out.println(personas);
    }
}
