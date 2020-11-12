package edu.eci.cvds.entities;

import java.util.Date;

public class Novedad {

    private int id;
    private int responsable;
    private Usuario usuario;
    private int equipo;
    private Equipo equipoObj;
    private int elemento;
    private Elemento elementoObj;
    private Date fecha;
    private String titulo;
    private String novedad;

    public Novedad(){}

    public Novedad(int id, int responsable, int equipo, int elemento, Date fecha, String titulo, String novedad){
        this.id = id;
        this.responsable = responsable;
        this.equipo = equipo;
        this.elemento = elemento;
        this.fecha = fecha;
        this.titulo = titulo;
        this.novedad = novedad;
    }

    public Novedad(int id, Usuario usuario, Equipo equipoObj, Elemento elementoObj, Date fecha, String titulo, String novedad){
        this.id = id;
        this.usuario = usuario;
        this.equipoObj = equipoObj;
        this.elementoObj = elementoObj;
        this.fecha = fecha;
        this.titulo = titulo;
        this.novedad = novedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Equipo getEquipoObj() { return equipoObj; }

    public void setEquipoObj(Equipo equipoObj) { this.equipoObj = equipoObj; }

    public Elemento getElementoObj() { return elementoObj; }

    public void setElementoObj(Elemento elementoObj) { this.elementoObj = elementoObj; }
}
