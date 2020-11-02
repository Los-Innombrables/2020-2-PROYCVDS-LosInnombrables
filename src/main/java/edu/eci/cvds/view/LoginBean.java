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
    // Creo que acá se crea la sesion en el navegador, se puede usar un filter para
    // restringir ciertas páginas, como por ejemplo las que sean /user/*, para que
    // haga verificación de que existe una sesión abierta antes de acceder a esas
    // páginas:
    // https://stackoverflow.com/questions/8480100/how-implement-a-login-filter-in-jsf
    // https://codenotfound.com/jsf-login-servlet-filter-example.html

    // TODO: verificar credenciales con la base de datos y crear la sesion con esas
    // credenciales

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesUsuario servicesUsuario;

    private String userName;
    private String password;
    private String canLog = " ";

    public String login() throws HistorialEquiposException {
        /*System.out.println(Objects.isNull(servicesUsuario));*/
        Usuario usuario = servicesUsuario.logInUsuario(userName, convertSHA256(password));
        FacesContext context = FacesContext.getCurrentInstance();

        if (usuario == null) {
            context.addMessage(null, new FacesMessage("Unknown login, try again"));
            this.setCanLog("Contraseña o Usuario Incorrectos");
            return null;
        } else {
            context.getExternalContext().getSessionMap().put("user", usuario);
            String webpage = redirectPage(usuario.getRol());
            this.setCanLog(" ");
            return webpage + "?faces-redirect=true";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/faces/main.xhtml?faces-redirect=true";
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

    public String redirectPage(int rol){
        String webPage = "";
        switch (rol){
            case 1:
                webPage = "/faces/dashboard/admin/main.xhtml";
                break;
            case 2:
                webPage = "/faces/dashboard/monitor/";
                break;
            case 3:
                webPage = "/faces/dashboard/profesor/";
                break;
        }
        return webPage;
    }

    public String getCanLog() {
        return canLog;
    }

    public void setCanLog(String canLog) {
        this.canLog = canLog;
    }
}