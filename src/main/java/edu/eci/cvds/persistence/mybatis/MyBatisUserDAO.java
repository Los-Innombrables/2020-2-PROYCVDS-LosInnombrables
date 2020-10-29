package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UsuarioMapper;

import javax.inject.Inject;

public class MyBatisUserDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public boolean logIn(String username, String passwd) throws HistorialEquiposException{
        try{
            Usuario usuario = usuarioMapper.logIn(username, passwd);
            if (usuario == null) {
                throw new HistorialEquiposException("Credenciales Invalidas");
            }
            else{
                return true;
            }
        }catch (Exception e){
            throw new HistorialEquiposException("Usuario o Contraseña Incorrectos");
        }
    }

    @Override
    public Usuario logInUsuario(String username, String passwd) throws HistorialEquiposException{
        try{
            Usuario usuario = usuarioMapper.logIn(username, passwd);
            if (usuario == null) {
                throw new HistorialEquiposException("Credenciales Invalidas");
            }
            else{
                return usuario;
            }
        }catch (Exception e){
            throw new HistorialEquiposException("Usuario o Contraseña Incorrectos");
        }
    }
}
