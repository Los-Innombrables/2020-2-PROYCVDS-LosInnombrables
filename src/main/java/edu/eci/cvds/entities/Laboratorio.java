package edu.eci.cvds.entities;

import java.util.Date;

public class Laboratorio {
    int id;
    String nombre;
    Date fechadeCreacion;
    Boolean activo;
    Date fechadeCierre;


    public Laboratorio(){}

    public Laboratorio(int id, String nombre, Date fechaDeCreacion, Boolean activo, Date fechaDeCierre){
        this.id = id;
        this.nombre = nombre;
        this.fechadeCreacion = fechaDeCreacion;
        this.activo = activo;
        this.fechadeCierre = fechaDeCierre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechadeCreacion() {
        return fechadeCreacion;
    }

    public void setFechadeCreacion(Date fechadeCreacion) {
        this.fechadeCreacion = fechadeCreacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechadeCierre() {
        return fechadeCierre;
    }

    public void setFechadeCierre(Date fechadeCierre) {
        this.fechadeCierre = fechadeCierre;
    }

}
