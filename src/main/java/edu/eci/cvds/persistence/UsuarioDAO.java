package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;

public interface UsuarioDAO {
    /* Para el login */
    boolean logIn(String username, String passwd) throws HistorialEquiposException;
    /* Para el login Con Usuario*/
    Usuario logInUsuario(String username, String passwd) throws HistorialEquiposException;

}
