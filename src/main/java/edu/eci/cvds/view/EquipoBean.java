package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.services.ServicesEquipo;

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

    public void registrarEquipo(String nombre, String activo, int laboratorio){
        Equipo equipo;
        if (activo.equalsIgnoreCase("inactivo")){
            equipo = new Equipo(1, laboratorio, nombre, false);
        }else{
            equipo = new Equipo(1, laboratorio, nombre, true);
        }
        servicesEquipo.addEquipo(equipo);
    }

}
