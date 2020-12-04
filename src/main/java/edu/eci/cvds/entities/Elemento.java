package edu.eci.cvds.entities;

import java.util.Date;

public class Elemento {

    private int id;
    private String tipo;
    private TipoElemento tipoElemento;
    private int equipo;
    private Equipo equipoOb;
    private String marca;
    private String referencia;
    private Date fechaDeRegistro;
    private boolean activo;
    private String nombre;

    private String activoS;

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

    public Elemento(int id, TipoElemento tipoElemento, Equipo equipo, String marca, String referencia, Date fechaDeRegistro, Boolean activo){
        this.id = id;
        this.tipoElemento = tipoElemento;
        this.equipoOb = equipo;
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

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getEquipo() { return equipo; }

    public void setEquipo(int equipo) { this.equipo = equipo; }

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

    public String getNombre() { this.nombre = (this.marca + " " + this.referencia);return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoElemento getTipoElemento() { return tipoElemento; }

    public void setTipoElemento(TipoElemento tipoElemento) { this.tipoElemento = tipoElemento; }

    public Equipo getEquipoOb() { return equipoOb; }

    public void setEquipoOb(Equipo equipoOb) { this.equipoOb = equipoOb; }

    public String getActivoS() { return activo ? "Activo" : "Inactivo"; }

    public void setActivoS(String activoS) { this.activoS = activoS; }
}
