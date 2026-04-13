package com.ejemplo.model.xml;

import com.ejemplo.model.Pedido;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "pedidos")
public class Pedidos {

    @JacksonXmlProperty(localName = "pedido")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Pedido> items = new ArrayList<>();

    public Pedidos() {
    }

    public Pedidos(List<Pedido> items) {
        this.items = items;
    }

    public List<Pedido> getItems() {
        return items;
    }

    public void setItems(List<Pedido> items) {
        this.items = items;
    }
}
