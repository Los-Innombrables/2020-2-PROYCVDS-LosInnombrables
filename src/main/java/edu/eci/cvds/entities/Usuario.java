package edu.eci.cvds.entities;

public class Usuario {

    private int carnet;
    private String nombre;
    private String apellido;
    private String correo;
    private String userName;
    private String passwd;
    private boolean activo;

    private int rol;
    private String rolS;

    private String activoS;

    public Usuario(){}

    public Usuario(int carnet, String nombre, String apellido, String correo, String userName, String passwd, boolean activo, int rol){
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.userName = userName;
        this.passwd = passwd;
        this.activo = activo;
        this.rol = rol;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        switch (rol){
            case 1:
                this.rolS = "Administrador";
                break;
            case 2:
                this.rolS = "Profesor";
                break;
            case 3:
                this.rolS = "Estudiante";
                break;
        }
        this.rol = rol;
    }

    public String getRolS() { return rolS; }

    public void setRolS(String rolS) { this.rolS = rolS; }

    public String getActivoS() { return activo ? "Activo" : "Inactivo"; }

    public void setActivoS(String activoS) { this.activoS = activoS; }
}
