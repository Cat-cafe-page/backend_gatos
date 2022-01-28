package com.catcafe.backend_gatos.models;
import org.springframework.data.annotation.Id;

public class Gatos {
    @Id
    private String  nombre;
    private Integer edad;
    private String añoAdopcion;
    private String  descripcion;
    private String  url;

    public Gatos(String nombre, Integer edad, String añoAdopcion, String  descripcion, String  url) {
        this.nombre = nombre;
        this.edad = edad;
        this.añoAdopcion = añoAdopcion;
        this.descripcion = descripcion;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getAñoAdopcion() {
        return añoAdopcion;
    }

    public void setAñoAdopcion(String añoAdopcion) {
        this.añoAdopcion = añoAdopcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
