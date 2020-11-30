package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UsuarioMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Usuario> consultarUsuarios() throws HistorialEquiposException {
        try{
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) usuarioMapper.consultarUsuarios();
            for(Usuario usuario : usuarios){
                String rolS = "";
                switch (usuario.getRol()) {
                    case 1:
                        rolS = "Administrador";
                        break;
                    case 2:
                        rolS = "Profesor";
                        break;
                    case 3:
                        rolS = "Estudiante";
                        break;
                }
                usuario.setRolS(rolS);
            }
            return usuarios;
        }catch (Exception e){
            throw new HistorialEquiposException("Error Al consultar Usuarios");
        }
    }

    @Override
    public void addUsuario(Usuario usuario) throws HistorialEquiposException {
        try{
            usuarioMapper.addUsuario(usuario);
        }catch (Exception e){
            e.printStackTrace();
            throw new HistorialEquiposException("Error al insertar usuario");
        }
    }

}
