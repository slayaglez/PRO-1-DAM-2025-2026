package com.docente.persistencia.impl;

import com.docente.modelo.Alumno;
import com.docente.modelo.AlumnoMatriculado;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAlumnoMatriculadoRepositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AlumnoMatriculadoRepositorioCSV implements IAlumnoMatriculadoRepositorio {

    private static final String PATH = "src/main/resources/alumnos_matriculados.csv";
    private final File file;

    public AlumnoMatriculadoRepositorioCSV() {
        this(PATH);
    }

    public AlumnoMatriculadoRepositorioCSV(String path) {
        this.file = new File(path);
        try {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new IllegalStateException("No se ha podido crear el fichero de alumnos matriculados", e);
        }
    }

    @Override
    public List<AlumnoMatriculado> obtenerAlumnosMatriculados() {
        List<AlumnoMatriculado> alumnosMat= new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split("|");
                String[] asignaturasStr = values[4].split(",");
                
                List<Asignatura> asignaturas = new ArrayList<>();
                for (String asignatura : asignaturasStr) {
                    asignaturas.add(new Asignatura(asignatura));
                }
                alumnosMat.add(new AlumnoMatriculado(values[0],values[1], Integer.parseInt(values[2].strip()), values[3], asignaturas));
            }
        }
        } catch (Exception e) {
            System.err.printf("No se ha podido leer el fichero :%s", PATH);
        }
        return alumnosMat;
    }

    @Override
    public boolean guardarAlumnosMatriculados(List<AlumnoMatriculado> alumnosMatriculados) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
                bw.write(alumnoMatriculado.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Error al guardar el fichero CSV.", e);
        }
        return true;
    }
}
