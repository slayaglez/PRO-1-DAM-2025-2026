package com.ejemplo.model.xml;

import com.ejemplo.model.Cliente;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "clientes")
public class Clientes {

    @JacksonXmlProperty(localName = "cliente")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cliente> items = new ArrayList<>();

    public Clientes() {
    }

    public Clientes(List<Cliente> items) {
        this.items = items;
    }

    public List<Cliente> getItems() {
        return items;
    }

    public void setItems(List<Cliente> items) {
        this.items = items;
    }
}
