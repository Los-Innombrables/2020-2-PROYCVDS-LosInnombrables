package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")
@SessionScoped

public class EquipoBean extends BasePageBean{

    private static final long serialVersionUID = 1L;
    private String tipoEstado;
    private List<Equipo> equipos;

    @Inject
    private ServicesEquipo servicesEquipo;

    public List<Equipo> consultarEquipos(){
        equipos = servicesEquipo.consultarEquipos();
        return equipos;
    }

    public void registrarEquipo(String nombre, String activoS, int laboratorio, int torre, int pantalla, int mouse, int teclado){
        int id = this.consultarNextId() + 1;
        Equipo equipo;
        boolean activo = false;
        if (activoS.equalsIgnoreCase("Activo")){
            activo = true;
        }
        equipo = new Equipo(id, laboratorio, nombre, activo);
        servicesEquipo.addEquipo(equipo);
        /*Para asociar Elementos*/
        ServicesElemento servicesElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesElemento();
        servicesElemento.actualizarEquipoAsociado(torre, id);
        servicesElemento.actualizarEquipoAsociado(pantalla, id);
        servicesElemento.actualizarEquipoAsociado(mouse, id);
        servicesElemento.actualizarEquipoAsociado(teclado, id);
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    private int consultarNextId(){
        this.consultarEquipos();
        int maxInt = 0;
        for (Equipo equipo : equipos){
            if (equipo.getId() > maxInt){ maxInt = equipo.getId();}
        }
        return maxInt;
    }

}
