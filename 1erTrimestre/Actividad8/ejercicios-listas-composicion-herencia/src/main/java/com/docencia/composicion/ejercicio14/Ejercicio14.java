package com.docencia.composicion.ejercicio14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que maneja listas de estudiantes en facultades
 * y a su vez listas de facultades en universidades. Se puede buscar a un estudiante
 * por Id y ver todos los estudiantes de la universidad
 */
public class Ejercicio14 {

    public static void main(String[] args) {
        Estudiante alumno1 = new Estudiante("1234A", "Sebas");
        Estudiante alumno2 = new Estudiante("4321B", "Ivan");
        Estudiante alumno3 = new Estudiante("4546C", "Yasiel");
        Estudiante alumno4 = new Estudiante("9876D", "Javi");
        Estudiante alumno5 = new Estudiante("4387E", "Jorge");

        List<Estudiante> alumnos1 = new ArrayList<>();
        alumnos1.add(alumno1);
        alumnos1.add(alumno2);
        alumnos1.add(alumno3);
        
        List<Estudiante> alumnos2 = new ArrayList<>();
        alumnos2.add(alumno4);
        alumnos2.add(alumno5);
        alumnos2.add(alumno3);


        Facultad mates = new Facultad(alumnos1);
        Facultad fisica = new Facultad(alumnos2);

        //System.out.println(mates);
        //System.out.println(fisica);

        List<Facultad> universidad = new ArrayList<>();
        universidad.add(mates);
        universidad.add(fisica);

        Universidad ull = new Universidad(universidad);
        List<Estudiante> totalEstudiantes = new ArrayList<>();
        //System.out.println(ull);

        totalEstudiantes = listaDeEstudiantes(ull);
        //System.out.println(totalEstudiantes);

        Estudiante alumnoFavorito = new Estudiante();
        alumnoFavorito = buscarPorId(ull, "1234A");
        System.out.println(alumnoFavorito);
    }

    /**
     * Pasada la universidad devuelve una lista de sus estudiantes
     * @param universidad la universidad (Universidad)
     * @return Lista de Estudiante
     */
    public static List<Estudiante> listaDeEstudiantes(Universidad universidad){
        
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        
        for (Facultad facultad : universidad.getUniversidad()) {
            listaEstudiantes.addAll(facultad.getFacultad());
        }

        return listaEstudiantes;
    }

    /**
     * Busca a un estudiante por su Id
     * @param universidad La universidad donde se busca
     * @param id el id del estudiante
     * @return El Estudiante
     */
    public static Estudiante buscarPorId(Universidad universidad, String id){
            
        for (Facultad facultad : universidad.getUniversidad()) {
            for (Estudiante estudiante : facultad.getFacultad()) {
                if(estudiante.getId().equals(id)){
                    return estudiante;
                }
            }
        }
        throw new IllegalArgumentException("El estudiante no existe");
    }
}
