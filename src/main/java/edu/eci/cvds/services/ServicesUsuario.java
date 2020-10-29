package edu.eci.cvds.services;

import edu.eci.cvds.entities.Usuario;

public interface ServicesUsuario {

    /*LogIn del usuario*/
    boolean logIn(String username, String passwd);
    /* Login con usuario*/
    Usuario logInUsuario(String username, String passwd);
}
