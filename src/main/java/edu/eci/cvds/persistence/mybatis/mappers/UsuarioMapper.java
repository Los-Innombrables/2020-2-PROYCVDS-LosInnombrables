package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UsuarioMapper {
    /* Consultar el login del usuario */
    Usuario logIn(@Param("username") String username, @Param("passwd") String passwd);

    List<Usuario> consultarUsuarios();

    void addUsuario (@Param("usuario") Usuario usuario);
}
