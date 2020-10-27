package edu.eci.cvds.view;

import edu.eci.cvds.entities.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginBean {
    // Creo que acá se crea la sesion en el navegador, se puede usar un filter para
    // restringir ciertas páginas, como por ejemplo las que sean /user/*, para que
    // haga verificación de que existe una sesión abierta antes de acceder a esas
    // páginas:
    // https://stackoverflow.com/questions/8480100/how-implement-a-login-filter-in-jsf
    // https://codenotfound.com/jsf-login-servlet-filter-example.html

    // TODO: verificar credenciales con la base de datos y crear la sesion con esas
    // credenciales
    public void login() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("daniel", "daniel");
            currentUser.login(token);
        }
    }
}