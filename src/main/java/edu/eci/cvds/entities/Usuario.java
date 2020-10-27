package edu.eci.cvds.entities;

public class Usuario {

    private int carnet;
    private String nombre;
    private String apellido;
    private String correo;
    private String userName;
    private String passwd;
    private String estado;

    public Usuario(){}

    public Usuario(int carnet, String nombre, String apellido, String correo, String userName, String passwd, String estado){
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.userName = userName;
        this.passwd = passwd;
        this.estado = estado;
    }


    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
