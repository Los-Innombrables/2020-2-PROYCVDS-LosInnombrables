package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ServicesUsuario;

import java.util.List;

public class ServicesUsuarioImpl implements ServicesUsuario {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public boolean logIn(String username, String passwd) throws HistorialEquiposException{
        try {
            return usuarioDAO.logIn(username, passwd);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public Usuario logInUsuario(String username, String passwd) throws HistorialEquiposException{
        try {
            return usuarioDAO.logInUsuario(username, passwd);
        } catch (Exception e) {
            throw new HistorialEquiposException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws HistorialEquiposException{
        try{
            return usuarioDAO.consultarUsuarios();
        }catch (Exception e){
            throw new HistorialEquiposException(e.getMessage());
        }
    }

}
