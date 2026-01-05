/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Composicion
 */

package com.docencia.composicion.ejercicio2;


import java.util.ArrayList;
import java.util.List;


public class Aula {

    private final List<RegistroNota> registros = new ArrayList<>();

    public void registrarNota(String nombreAlumno, String asignatura, double nota) {
        // TODO: validar campos y rango de nota según enunciado.
        if (nombreAlumno != null && !(nombreAlumno.isBlank()) && asignatura != null && nota >= 0) {
            registros.add(new RegistroNota(new Alumno(nombreAlumno), asignatura, nota));
        }
    }

    public double mediaAlumno(String nombreAlumno) {

        if(nombreAlumno==null || nombreAlumno.isBlank()){
            return 0.0;
        }

        double media=0;
        int numeroNotas=0;

        for (int i = 0; i < registros.size(); i++) {
            String nombreAlumnoRegistro = registros.get(i).getAlumno().getNombre().trim().toLowerCase();
            if(nombreAlumnoRegistro.equals(nombreAlumno.trim().toLowerCase()) && registros.get(i).getNota()>0){
                media += registros.get(i).getNota();
                numeroNotas++;
            }
        }
        if(media==0){
            return 0.0;
        }
        media /= numeroNotas;
        return media;
    }

    public List<RegistroNota> getRegistros() {
        return registros;
    }
    
}
