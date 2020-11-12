package edu.eci.cvds.entities;

public class Equipo {
    private int id;
    private int laboratorio;
    private Laboratorio laboratorioObj;
    private String nombre;
    private Boolean activo;

    public Equipo() {
    }

    public Equipo(int id, int laboratorio, String nombre, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.activo = activo;
    }

    public Equipo(int id, Laboratorio laboratorioObj, String nombre, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorioObj = laboratorioObj;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaboratorio() { return laboratorio; }

    public void setLaboratorio(int laboratorio) { this.laboratorio = laboratorio; }

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

    public Laboratorio getLaboratorioObj() { return laboratorioObj; }

    public void setLaboratorioObj(Laboratorio laboratorioObj) { this.laboratorioObj = laboratorioObj; }

}
