package com.example.xmlandroidjava;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "consulta_provinciero", strict = false)
public class Provinciero {
    @ElementList(name = "provinciero")
    private List<Provincia> provincias;

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        return "Provinciero{" +
                "provincias=" + provincias +
                '}';
    }
}
