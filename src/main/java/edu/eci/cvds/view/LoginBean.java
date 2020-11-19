package edu.eci.cvds.view;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesUsuario;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean extends BasePageBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesUsuario servicesUsuario;

    private String userName;
    private String password;
    private String canLog = " ";
    private String rol;
    private Usuario usuario;
    private int usuarioCarnet;

    public static String redirectPage(int rol) {
        return "/faces/dashboard/main.xhtml";
    }

    public String login() {
        /* System.out.println(Objects.isNull(servicesUsuario)); */
        try {
            this.password = convertSHA256(password);
            usuario = servicesUsuario.logInUsuario(userName, password);
            rol = usuario.getRolS();
            FacesContext context = FacesContext.getCurrentInstance();
            if (usuario == null) {
                context.addMessage(null, new FacesMessage("Unknown login, try again"));
                this.setCanLog("Contraseña o Usuario Incorrectos");
                return null;
            } else {
                context.getExternalContext().getSessionMap().put("user", usuario);
                String webpage = redirectPage(usuario.getRol());
                usuarioCarnet = usuario.getCarnet();
                this.setCanLog(" ");
                return webpage + "?faces-redirect=true";
            }
        } catch (Exception e) {
            this.setCanLog("Contraseña o Usuario Incorrectos");
            return null;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/faces/login.xhtml?faces-redirect=true";
    }

    private String convertSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public boolean canEdit(){ return usuario.getRol() != 3; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCanLog() {
        return canLog;
    }

    public void setCanLog(String canLog) {
        this.canLog = canLog;
    }

    public int getUsuarioCarnet() {
        return usuarioCarnet;
    }

    public void setUsuarioCarnet(int usuarioCarnet) {
        this.usuarioCarnet = usuarioCarnet;
    }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}