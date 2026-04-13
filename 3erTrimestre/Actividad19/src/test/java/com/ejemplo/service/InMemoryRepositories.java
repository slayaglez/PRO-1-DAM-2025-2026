package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Inventario;
import com.ejemplo.model.LineaPedido;
import com.ejemplo.model.Pedido;
import com.ejemplo.model.Producto;
import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IClienteRepository;
import com.ejemplo.repository.IInventarioRepository;
import com.ejemplo.repository.ILineaPedidoRepository;
import com.ejemplo.repository.IPedidoRepository;
import com.ejemplo.repository.IProductoRepository;
import com.ejemplo.repository.IProveedorRepository;
import java.util.ArrayList;
import java.util.List;

class InMemoryClienteRepository implements IClienteRepository {
    private List<Cliente> data = new ArrayList<>();

    public boolean create(Cliente cliente) {
        if (cliente == null || cliente.getId() == null || findById(cliente.getId()) != null) {
            return false;
        }
        data.add(cliente);
        return true;
    }

    public List<Cliente> findAll() {
        return new ArrayList<>(data);
    }

    public Cliente findById(Long id) {
        for (Cliente cliente : data) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean update(Cliente cliente) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(cliente.getId())) {
                data.set(i, cliente);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(cliente -> cliente.getId().equals(id));
    }
}

class InMemoryProductoRepository implements IProductoRepository {
    private List<Producto> data = new ArrayList<>();

    public boolean create(Producto producto) {
        if (producto == null || producto.getId() == null || findById(producto.getId()) != null) {
            return false;
        }
        data.add(producto);
        return true;
    }

    public List<Producto> findAll() {
        return new ArrayList<>(data);
    }

    public Producto findById(Long id) {
        for (Producto producto : data) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public boolean update(Producto producto) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(producto.getId())) {
                data.set(i, producto);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(producto -> producto.getId().equals(id));
    }
}

class InMemoryProveedorRepository implements IProveedorRepository {
    private List<Proveedor> data = new ArrayList<>();

    public boolean create(Proveedor proveedor) {
        if (proveedor == null || proveedor.getId() == null || findById(proveedor.getId()) != null) {
            return false;
        }
        data.add(proveedor);
        return true;
    }

    public List<Proveedor> findAll() {
        return new ArrayList<>(data);
    }

    public Proveedor findById(Long id) {
        for (Proveedor proveedor : data) {
            if (proveedor.getId().equals(id)) {
                return proveedor;
            }
        }
        return null;
    }

    public boolean update(Proveedor proveedor) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(proveedor.getId())) {
                data.set(i, proveedor);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(proveedor -> proveedor.getId().equals(id));
    }
}

class InMemoryInventarioRepository implements IInventarioRepository {
    private List<Inventario> data = new ArrayList<>();

    public boolean create(Inventario inventario) {
        if (inventario == null || inventario.getId() == null || findById(inventario.getId()) != null) {
            return false;
        }
        data.add(inventario);
        return true;
    }

    public List<Inventario> findAll() {
        return new ArrayList<>(data);
    }

    public Inventario findById(Long id) {
        for (Inventario inventario : data) {
            if (inventario.getId().equals(id)) {
                return inventario;
            }
        }
        return null;
    }

    public boolean update(Inventario inventario) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(inventario.getId())) {
                data.set(i, inventario);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(inventario -> inventario.getId().equals(id));
    }
}

class InMemoryPedidoRepository implements IPedidoRepository {
    private List<Pedido> data = new ArrayList<>();

    public boolean create(Pedido pedido) {
        if (pedido == null || pedido.getId() == null || findById(pedido.getId()) != null) {
            return false;
        }
        data.add(pedido);
        return true;
    }

    public List<Pedido> findAll() {
        return new ArrayList<>(data);
    }

    public Pedido findById(Long id) {
        for (Pedido pedido : data) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }
        return null;
    }

    public boolean update(Pedido pedido) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(pedido.getId())) {
                data.set(i, pedido);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(pedido -> pedido.getId().equals(id));
    }
}

class InMemoryLineaPedidoRepository implements ILineaPedidoRepository {
    private List<LineaPedido> data = new ArrayList<>();

    public boolean create(LineaPedido lineaPedido) {
        if (lineaPedido == null || lineaPedido.getId() == null || findById(lineaPedido.getId()) != null) {
            return false;
        }
        data.add(lineaPedido);
        return true;
    }

    public List<LineaPedido> findAll() {
        return new ArrayList<>(data);
    }

    public LineaPedido findById(Long id) {
        for (LineaPedido lineaPedido : data) {
            if (lineaPedido.getId().equals(id)) {
                return lineaPedido;
            }
        }
        return null;
    }

    public boolean update(LineaPedido lineaPedido) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId().equals(lineaPedido.getId())) {
                data.set(i, lineaPedido);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        return data.removeIf(lineaPedido -> lineaPedido.getId().equals(id));
    }
}
