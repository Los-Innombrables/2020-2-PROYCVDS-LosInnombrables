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
    public void login() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("daniel", "daniel");
            currentUser.login(token);
        }
    }
}