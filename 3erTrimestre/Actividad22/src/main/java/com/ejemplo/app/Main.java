package com.ejemplo.app;

import com.ejemplo.repository.sqlite.SchemaRepository;

public class Main {

    public static void main(String[] args) {
        String rutaDb = "src/main/resources/data/sqlite/employee.db";
        new SchemaRepository(rutaDb).createSchema();
        System.out.println("Base de datos creada en " + rutaDb);
        System.out.println("Implementa los servicios y ejecuta mvn test.");
    }
}
