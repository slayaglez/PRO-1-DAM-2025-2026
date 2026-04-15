package com.ejemplo.repository.csv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    @Test
    void readManualCsvWithCustomSeparator() {
        try {
            Path file = Files.createTempFile("clientes", ".csv");
            Files.writeString(file, "id;nombre\n1;Ana\n2;Luis\n");

            ClienteCsvRepository reader = new ClienteCsvRepository(file.toString(), ";", ";");
            assertEquals(2, reader.read(file, ";", true).size());
        } catch (Exception e) {
            Assertions.fail("Se produjo un error al crear el archivo CSV de prueba: " + e.getMessage());
        }

    }

    @Test
    void readManualCsvSkipsEmptyLines() {
        try {
            Path file = Files.createTempFile("productos", ".csv");
            Files.writeString(file, "id;nombre\n1;Teclado\n\n2;Raton\n");

            ClienteCsvRepository reader = new ClienteCsvRepository(file.toString(), ";", ";");

            assertEquals(2, reader.read(file, ";", true).size());
        } catch (Exception e) {
            Assertions.fail("Se produjo un error al crear el archivo CSV de prueba: " + e.getMessage());
        }

    }
}
