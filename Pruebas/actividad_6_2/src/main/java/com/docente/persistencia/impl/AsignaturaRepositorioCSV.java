package com.docente.persistencia.impl;

import com.docente.modelo.Alumno;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AsignaturaRepositorioCSV implements IAsignaturaRepositorio {

    private static final String PATH = "src/main/resources/asignaturas.csv";
    private final File file;

    public AsignaturaRepositorioCSV() {
        this(PATH);
    }

    /**
     * Constructor del fichero
     * @param path ruta
     */
    public AsignaturaRepositorioCSV(String path) {
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
            throw new IllegalStateException("No se ha podido crear el fichero de asignaturas", e);
        }
    }


    /**
     * Metodo que lee las asignaturas del fichero
     */
    @Override
    public List<Asignatura> obtenerAsignaturas() {
        List<Asignatura> asignaturas= new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("|");
                asignaturas.add(new Asignatura(values[0],values[1], Integer.parseInt(values[2].strip())));
            }
        }
        } catch (Exception e) {
            System.err.printf("No se ha podido leer el fichero: "+PATH);
        }
        return asignaturas;
    }

    /**
     * Metodo para escribir asignaturas en el fichero
     */
    @Override
    public boolean guardarAsignaturas(List<Asignatura> asignaturas) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Asignatura asignatura : asignaturas) {
                bw.write(asignatura.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Error al guardar el fichero CSV.", e);
        }
        return true;
    }
}
