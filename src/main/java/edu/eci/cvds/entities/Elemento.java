package edu.eci.cvds.entities;

import java.util.Date;

public class Elemento {

    private int id;
    private String tipo;
    private int equipo;
    private String marca;
    private String referencia;
    private Date fechaDeRegistro;
    private boolean activo;
    private String nombre;

    public Elemento(){}

    public Elemento(int id, String tipo, int equipo, String marca, String referencia, Date fechaDeRegistro, Boolean activo){
        this.id = id;
        this.tipo = tipo;
        this.equipo = equipo;
        this.marca = marca;
        this.referencia = referencia;
        this.fechaDeRegistro = fechaDeRegistro;
        this.activo = activo;
        this.nombre = (this.marca + " " + this.referencia);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        this.nombre = (this.marca + " " + this.referencia);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
