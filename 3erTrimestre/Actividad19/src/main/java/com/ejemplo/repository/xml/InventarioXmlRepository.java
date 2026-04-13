package com.ejemplo.repository.xml;

import com.ejemplo.model.Inventario;
import com.ejemplo.model.xml.Inventarios;
import com.ejemplo.repository.IInventarioRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InventarioXmlRepository implements IInventarioRepository {

    private Path path;
    private XmlMapper xmlMapper;

    public InventarioXmlRepository(String path) {
        this.path = inicializarPath(path);
        this.xmlMapper = new XmlMapper();
    }

    public boolean create(Inventario inventario) {
        if (inventario == null || inventario.getId() == null || findById(inventario.getId()) != null) {
            return false;
        }
        List<Inventario> inventarios = findAll();
        inventarios.add(inventario);
        writeAll(inventarios);
        return true;
    }

    public List<Inventario> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            Inventarios wrapper = xmlMapper.readValue(path.toFile(), Inventarios.class);
            List<Inventario> inventarios = wrapper.getItems();
            return inventarios == null ? new ArrayList<>() : inventarios;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el fichero XML de inventarios", e);
        }
    }

    public Inventario findById(Long id) {
        List<Inventario> inventarios = findAll();
        for (Inventario inventario : inventarios) {
            if (inventario.getId().equals(id)) {
                return inventario;
            }
        }
        return null;
    }

    public boolean update(Inventario inventarioActualizado) {
        List<Inventario> inventarios = findAll();
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getId().equals(inventarioActualizado.getId())) {
                inventarios.set(i, inventarioActualizado);
                writeAll(inventarios);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        List<Inventario> inventarios = findAll();
        boolean eliminado = inventarios.removeIf(inventario -> inventario.getId().equals(id));
        if (eliminado) {
            writeAll(inventarios);
        }
        return eliminado;
    }

    private void writeAll(List<Inventario> inventarios) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Inventarios wrapper = new Inventarios();
            wrapper.setItems(inventarios);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), wrapper);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir el fichero XML de inventarios", e);
        }
    }

    private Path inicializarPath(String ruta) {
        try {
            Path path = Path.of(ruta);
            crearCarpetasSiNoExisten(path);
            comprobarQueNoEsDirectorio(path, ruta);
            crearFicheroSiNoExiste(path);
            return path;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo preparar el fichero XML: " + ruta, e);
        }
    }

    private void crearCarpetasSiNoExisten(Path path) throws IOException {
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
    }

    private void comprobarQueNoEsDirectorio(Path path, String ruta) {
        if (Files.exists(path) && Files.isDirectory(path)) {
            throw new RuntimeException("La ruta indicada es un directorio: " + ruta);
        }
    }

    private void crearFicheroSiNoExiste(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }
}
