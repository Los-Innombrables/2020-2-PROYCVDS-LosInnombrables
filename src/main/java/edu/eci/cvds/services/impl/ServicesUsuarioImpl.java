package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ServicesUsuario;

public class ServicesUsuarioImpl implements ServicesUsuario {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public boolean logIn(String username, String passwd) {
        try {
            return usuarioDAO.logIn(username, passwd);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Usuario logInUsuario(String username, String passwd) {
        try {
            return usuarioDAO.logInUsuario(username, passwd);
        } catch (Exception e) {
            return null;
        }
    }

}
