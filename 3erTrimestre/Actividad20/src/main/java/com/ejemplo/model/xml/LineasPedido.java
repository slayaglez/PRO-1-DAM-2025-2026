package com.ejemplo.model.xml;

import com.ejemplo.model.LineaPedido;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "lineas")
public class LineasPedido {

    @JacksonXmlProperty(localName = "lineapedido")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<LineaPedido> items = new ArrayList<>();

    public LineasPedido() {
    }

    public LineasPedido(List<LineaPedido> items) {
        this.items = items;
    }

    public List<LineaPedido> getItems() {
        return items;
    }

    public void setItems(List<LineaPedido> items) {
        this.items = items;
    }
}
