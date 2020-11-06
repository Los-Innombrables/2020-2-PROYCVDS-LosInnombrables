package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")
@SessionScoped

public class EquipoBean extends BasePageBean{

    private static final long serialVersionUID = 1L;
    private String tipoEstado;

    @Inject
    private ServicesEquipo servicesEquipo;

    private String selectedEquipo;
    private String selectedEquipoAct;

    /*Dar de baja*/
    private String torreE;
    private String mouseE;
    private String tecladoE;
    private String pantallaE;


    public ArrayList<Equipo> consultarEquipos() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) servicesEquipo.consultarEquipos();
        equipos.sort(Comparator.comparing(Equipo::getId));
        return equipos;
    }

    public void registrarEquipo(String nombre, String activoS, int laboratorio, int torre, int pantalla, int mouse, int teclado, int responsable) throws HistorialEquiposException {
        int id = this.consultarNextId() + 1;
        Equipo equipo;
        boolean activo = false;
        if (activoS.equalsIgnoreCase("Activo")){
            activo = true;
        }
        equipo = new Equipo(id, laboratorio, nombre, activo);
        servicesEquipo.addEquipo(equipo);
        /*Para asociar Elementos*/
        asociarElemento(id, torre, pantalla, mouse, teclado);
        /*Para Registrar Novedades*/
        generarNovedad(id, torre, pantalla, mouse, teclado, responsable, equipo);

    }

    private void asociarElemento(int id, int torre, int pantalla, int mouse, int teclado) throws HistorialEquiposException {
        /*Para asociar Elementos*/
        ServicesElemento servicesElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesElemento();
        servicesElemento.actualizarEquipoAsociado(torre, id);
        servicesElemento.actualizarEquipoAsociado(pantalla, id);
        servicesElemento.actualizarEquipoAsociado(mouse, id);
        servicesElemento.actualizarEquipoAsociado(teclado, id);
    }

    private void generarNovedad(int id, int torre, int pantalla, int mouse, int teclado, int responsable, Equipo equipo) throws HistorialEquiposException {
        /*Para Registrar Novedades*/
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, torre, null,
                "Elemento Nuevo Registrado", "Se registro un nuevo elemento de tipo torre al equipo " + equipo.getNombre()));
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, pantalla, null,
                "Elemento Nuevo Registrado", "Se registro un nuevo elemento de tipo pantalla al equipo " + equipo.getNombre()));
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, mouse, null,
                "Elemento Nuevo Registrado", "Se registro un nuevo elemento de tipo mouse al equipo " + equipo.getNombre()));
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, teclado, null,
                "Elemento Nuevo Registrado", "Se registro un nuevo elemento de tipo teclado al equipo " + equipo.getNombre()));
    }

    public void darDeBajaEquipo(int id, String torreE, String mouseE, String pantallaE, String tecladoE, int responsable) throws HistorialEquiposException {
        servicesEquipo.darDeBajaEquipo(id, false);

        ServicesElemento servicesElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesElemento();
        servicesElemento.eliminarElementos(id, torreE, mouseE, pantallaE, tecladoE, responsable);

        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        Novedad novedad = new Novedad(1, responsable, id, 0, null, "Equipo Dado de baja", "El equipo fue dado de baja.");
        servicesNovedad.registrarNovedad(novedad);
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    private int consultarNextId() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = consultarEquipos();
        int maxInt = 0;
        for (Equipo equipo : equipos){
            if (equipo.getId() > maxInt){ maxInt = equipo.getId();}
        }
        return maxInt;
    }

    /*Crear Objeto Interno*/
    public Map<String, Integer> getEquipoMap() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = consultarEquipos();
        Map<String, Integer> equipoMap = new LinkedHashMap<String,Integer>();
        for(Equipo equipo : equipos){
            equipoMap.put(equipo.getNombre(), equipo.getId());
        }
        return equipoMap;
    }

    public Map<String, Integer> getEquipoMapActivo() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = consultarEquipos();
        Map<String, Integer> equipoMap = new LinkedHashMap<String,Integer>();
        for(Equipo equipo : equipos){
            if(equipo.getActivo()){
                equipoMap.put(equipo.getNombre(), equipo.getId());
            }
        }
        return equipoMap;
    }

    public String getSelectedEquipo() {
        return selectedEquipo;
    }

    public void setSelectedEquipo(String selectedEquipo) {
        this.selectedEquipo = selectedEquipo;
    }

    public String getSelectedEquipoAct() {
        return selectedEquipoAct;
    }

    public void setSelectedEquipoAct(String selectedEquipoAct) {
        this.selectedEquipoAct = selectedEquipoAct;
    }

    public String getTorreE() {
        return torreE;
    }

    public void setTorreE(String torreE) {
        this.torreE = torreE;
    }

    public String getMouseE() {
        return mouseE;
    }

    public void setMouseE(String mouseE) {
        this.mouseE = mouseE;
    }

    public String getTecladoE() {
        return tecladoE;
    }

    public void setTecladoE(String tecladoE) {
        this.tecladoE = tecladoE;
    }

    public String getPantallaE() {
        return pantallaE;
    }

    public void setPantallaE(String pantallaE) {
        this.pantallaE = pantallaE;
    }
}
