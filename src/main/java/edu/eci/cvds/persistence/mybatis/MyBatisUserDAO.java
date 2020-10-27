package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UsuarioMapper;

import javax.inject.Inject;

public class MyBatisUserDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    public boolean logIn(String username, String passwd) throws HistorialEquiposException{
        try{
            Usuario usuario = usuarioMapper.logIn(username, passwd);
            if (usuario == null){
                throw new HistorialEquiposException("Credenciales Invalidas");
            } else if(usuario.getEstado().equals(false)){
                throw new HistorialEquiposException("Usuario Inactivo");
            }
            else{
                boolean result = (usuario.getUserName().equals(username) && usuario.getPasswd().equals(passwd));
                return result;
            }
        }catch (Exception e){
            throw new HistorialEquiposException("Credenciales Invalidas");
        }
    }

}
