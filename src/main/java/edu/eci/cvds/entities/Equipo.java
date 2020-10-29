package edu.eci.cvds.entities;

public class Equipo {
    int id;
    int laboratorio;
    String nombre;
    Boolean activo;

    public Equipo() {
    }

    public Equipo(int id, int laboratorio, String nombre, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}
