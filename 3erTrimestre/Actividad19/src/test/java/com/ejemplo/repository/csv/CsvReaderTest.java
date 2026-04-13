package com.ejemplo.repository.csv;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    @Test
    void readManualCsvWithCustomSeparator() throws Exception {
        Path file = Files.createTempFile("clientes", ".csv");
        Files.writeString(file, "id;nombre\n1;Ana\n2;Luis\n");

        ClienteCsvRepository reader = new ClienteCsvRepository(file.toString(), ";", ";");
        assertEquals(2, reader.read(file, ";", true).size());
    }

    @Test
    void readManualCsvSkipsEmptyLines() throws Exception {
        Path file = Files.createTempFile("productos", ".csv");
        Files.writeString(file, "id;nombre\n1;Teclado\n\n2;Raton\n");

        ClienteCsvRepository reader = new ClienteCsvRepository(file.toString(), ";", ";");

        assertEquals(2, reader.read(file, ";", true).size());
    }
}
