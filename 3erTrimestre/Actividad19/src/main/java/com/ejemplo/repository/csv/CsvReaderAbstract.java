package com.ejemplo.repository.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

abstract class CsvReaderAbstract {

    public List<String[]> read(Path path, String separatorRegex, boolean skipHeader) throws IOException {
        List<String[]> rows = new ArrayList<>();

        if (!Files.exists(path)) {
            return rows;
        }

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine && skipHeader) {
                    firstLine = false;
                    continue;
                }
                firstLine = false;

                if (line.trim().isEmpty()) {
                    continue;
                }

                rows.add(line.split(separatorRegex, -1));
            }
        }

        return rows;
    }
}
