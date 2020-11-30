package edu.eci.cvds.services;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ServicesUsuario {

    /*LogIn del usuario*/
    boolean logIn(String username, String passwd) throws HistorialEquiposException;
    /* Login con usuario*/
    Usuario logInUsuario(String username, String passwd) throws HistorialEquiposException;
    /* Consultar */
    List<Usuario> consultarUsuarios() throws HistorialEquiposException;

    void addUsuario (Usuario usuario) throws HistorialEquiposException;
}
