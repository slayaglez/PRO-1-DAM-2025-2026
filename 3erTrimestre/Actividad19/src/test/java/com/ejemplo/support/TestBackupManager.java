package com.ejemplo.support;

import com.ejemplo.repository.sqlite.SQLiteConnectionManager;
import com.ejemplo.repository.sqlite.SchemaRepository;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class TestBackupManager {

    private Path tempDir;
    private Path backupDir;
    private Path workingDir;

    public TestBackupManager(Path tempDir) {
        this.tempDir = tempDir;
        this.backupDir = tempDir.resolve("backup");
        this.workingDir = tempDir.resolve("working");
        prepararEntorno();
    }

    public Path restaurarCsv(String nombreFichero) {
        return restaurarFicheroVacio("csv", nombreFichero);
    }

    public Path restaurarJson(String nombreFichero) {
        return restaurarFicheroVacio("json", nombreFichero);
    }

    public Path restaurarXml(String nombreFichero) {
        return restaurarFicheroVacio("xml", nombreFichero);
    }

    public void restaurarSqlite(String nombreBaseDatos) {
        try {
            Path backupDb = backupDir.resolve("sqlite").resolve("base.db");
            Path workingDb = workingDir.resolve("sqlite").resolve(nombreBaseDatos);
            Files.createDirectories(workingDb.getParent());
            Files.copy(backupDb, workingDb, StandardCopyOption.REPLACE_EXISTING);
            //return new SQLiteConnectionManager(workingDb.toString());
        } catch (Exception e) {
            throw new RuntimeException("No se pudo restaurar la copia de seguridad de SQLite", e);
        }
    }

    private Path restaurarFicheroVacio(String tipo, String nombreFichero) {
        try {
            Path backupFile = asegurarBackupVacio(tipo, nombreFichero);
            Path workingFile = workingDir.resolve(tipo).resolve(nombreFichero);
            Files.createDirectories(workingFile.getParent());
            Files.copy(backupFile, workingFile, StandardCopyOption.REPLACE_EXISTING);
            return workingFile;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo restaurar la copia de seguridad del fichero " + nombreFichero, e);
        }
    }

    private void prepararEntorno() {
        try {
            Files.createDirectories(tempDir);
            Files.createDirectories(backupDir.resolve("csv"));
            Files.createDirectories(backupDir.resolve("json"));
            Files.createDirectories(backupDir.resolve("xml"));
            Files.createDirectories(backupDir.resolve("sqlite"));
            Files.createDirectories(workingDir.resolve("csv"));
            Files.createDirectories(workingDir.resolve("json"));
            Files.createDirectories(workingDir.resolve("xml"));
            Files.createDirectories(workingDir.resolve("sqlite"));

        } catch (Exception e) {
            throw new RuntimeException("No se pudo preparar el entorno de copias de seguridad de test", e);
        }
    }

    private Path asegurarBackupVacio(String tipo, String nombreFichero) throws Exception {
        Path backupFile = backupDir.resolve(tipo).resolve(nombreFichero);
        if (!Files.exists(backupFile)) {
            Files.createDirectories(backupFile.getParent());
            Files.writeString(backupFile, "");
        }
        return backupFile;
    }

    }
