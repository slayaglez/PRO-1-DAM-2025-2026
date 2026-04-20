package com.ejemplo.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.ejemplo.model.Propietario;
import com.ejemplo.model.Inmueble;
import com.ejemplo.repository.sqlite.SchemaRepository;
import com.ejemplo.service.PropietarioService;
import com.ejemplo.service.InmuebleService;

public class Main {

    public static void main(String[] args) {
        String rutaDb = "src/main/resources/data/sqlite/inmuebles.db";
        String rutaBackupDb = "src/main/resources/data/sqlite/inmuebles_backup.db";

        try {
            Files.copy(
                        Path.of(rutaBackupDb),
                        Path.of(rutaDb),
                        StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new SchemaRepository(rutaDb).createSchema();

        PropietarioService propietarioService = new PropietarioService();
        InmuebleService inmuebleService = new InmuebleService();

        Propietario propietario = new Propietario("11111111A", "Ana", "ana@demo.com", "600111222", "Madrid", true);
        propietarioService.crear(propietario);

        Inmueble inmueble = new Inmueble(null, "REF-001", "Piso", "Calle Mayor 1", "Madrid", 2021, 95, 125000.0, false, propietario.getDni());
        inmuebleService.crear(inmueble);

        System.out.println("Propietarios: " + propietarioService.listarTodos());
        System.out.println("Inmuebles: " + inmuebleService.listarTodos());
    }
}
