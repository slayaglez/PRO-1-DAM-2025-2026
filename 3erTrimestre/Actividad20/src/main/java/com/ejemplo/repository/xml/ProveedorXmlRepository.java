package com.ejemplo.repository.xml;

import com.ejemplo.model.Proveedor;
import com.ejemplo.model.xml.Proveedores;
import com.ejemplo.repository.IProveedorRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProveedorXmlRepository implements IProveedorRepository {

    private Path path;
    private XmlMapper xmlMapper;

    public ProveedorXmlRepository(String path) {
        this.path = inicializarPath(path);
        this.xmlMapper = new XmlMapper();
    }

    public boolean create(Proveedor proveedor) {
        if (proveedor == null || proveedor.getId() == null || findById(proveedor.getId()) != null) {
            return false;
        }
        List<Proveedor> proveedores = findAll();
        proveedores.add(proveedor);
        writeAll(proveedores);
        return true;
    }

    public List<Proveedor> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            Proveedores wrapper = xmlMapper.readValue(path.toFile(), Proveedores.class);
            List<Proveedor> proveedores = wrapper.getItems();
            return proveedores == null ? new ArrayList<>() : proveedores;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el fichero XML de proveedores", e);
        }
    }

    public Proveedor findById(Long id) {
        List<Proveedor> proveedores = findAll();
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getId().equals(id)) {
                return proveedor;
            }
        }
        return null;
    }

    public boolean update(Proveedor proveedorActualizado) {
        List<Proveedor> proveedores = findAll();
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getId().equals(proveedorActualizado.getId())) {
                proveedores.set(i, proveedorActualizado);
                writeAll(proveedores);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        List<Proveedor> proveedores = findAll();
        boolean eliminado = proveedores.removeIf(proveedor -> proveedor.getId().equals(id));
        if (eliminado) {
            writeAll(proveedores);
        }
        return eliminado;
    }

    private void writeAll(List<Proveedor> proveedores) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Proveedores wrapper = new Proveedores();
            wrapper.setItems(proveedores);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), wrapper);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir el fichero XML de proveedores", e);
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
