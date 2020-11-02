package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@SessionScoped

public class UsuarioBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesUsuario servicesUsuario;

    public List<Usuario> consultarEquipos() throws HistorialEquiposException {
        return servicesUsuario.consultarUsuarios();
    }


}