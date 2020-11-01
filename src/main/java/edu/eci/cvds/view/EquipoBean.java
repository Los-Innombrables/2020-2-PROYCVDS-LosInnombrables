package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")
@SessionScoped

public class EquipoBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesEquipo servicesEquipo;

    public List<Equipo> consultarEquipos(){
        return servicesEquipo.consultarEquipos();
    }

}
