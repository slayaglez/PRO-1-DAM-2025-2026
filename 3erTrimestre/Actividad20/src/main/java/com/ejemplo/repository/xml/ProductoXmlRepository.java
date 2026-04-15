package com.ejemplo.repository.xml;

import com.ejemplo.model.Producto;
import com.ejemplo.model.xml.Productos;
import com.ejemplo.repository.IProductoRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductoXmlRepository implements IProductoRepository {

    private Path path;
    private XmlMapper xmlMapper;

    public ProductoXmlRepository(String path) {
        this.path = inicializarPath(path);
        this.xmlMapper = new XmlMapper();
    }

    public boolean create(Producto producto) {
        if (producto == null || producto.getId() == null || findById(producto.getId()) != null) {
            return false;
        }
        List<Producto> productos = findAll();
        productos.add(producto);
        writeAll(productos);
        return true;
    }

    public List<Producto> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            Productos wrapper = xmlMapper.readValue(path.toFile(), Productos.class);
            List<Producto> productos = wrapper.getItems();
            return productos == null ? new ArrayList<>() : productos;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el fichero XML de productos", e);
        }
    }

    public Producto findById(Long id) {
        List<Producto> productos = findAll();
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public boolean update(Producto productoActualizado) {
        List<Producto> productos = findAll();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(productoActualizado.getId())) {
                productos.set(i, productoActualizado);
                writeAll(productos);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        List<Producto> productos = findAll();
        boolean eliminado = productos.removeIf(producto -> producto.getId().equals(id));
        if (eliminado) {
            writeAll(productos);
        }
        return eliminado;
    }

    private void writeAll(List<Producto> productos) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Productos wrapper = new Productos();
            wrapper.setItems(productos);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), wrapper);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir el fichero XML de productos", e);
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
