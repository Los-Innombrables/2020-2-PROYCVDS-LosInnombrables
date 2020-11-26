package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesNovedad;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "equipoBean")
@SessionScoped

public class EquipoBean extends BasePageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tipoEstado;

    private Equipo equipo;
    private ArrayList<Equipo> equiposSeleccionados;

    @Inject
    private ServicesEquipo servicesEquipo;
    @Inject
    private ServicesElemento servicesElemento;

    private String selectedEquipo;
    private String selectedEquipoAct;

    /* Dar de baja */
    private String torreE;
    private String mouseE;
    private String tecladoE;
    private String pantallaE;

    /* Exportar */

    private Exporter<DataTable> textExporter = new TextExporter();

    private ArrayList<Equipo> equipos;

    public ArrayList<Equipo> consultarEquiposObj() throws HistorialEquiposException {
        if (equipos == null) {
            equipos = (ArrayList<Equipo>) servicesEquipo.consultarEquiposObj();
        }
        return equipos;
    }

    public void registrarEquipo(String nombre, String activoS, int laboratorio, int torre, int pantalla, int mouse,
            int teclado, int responsable) throws HistorialEquiposException {
        int id = this.consultarNextId() + 1;
        Equipo equipo;
        boolean activo = false;
        if (activoS.equalsIgnoreCase("Activo")) {
            activo = true;
        }
        equipo = new Equipo(id, laboratorio, nombre, activo);
        servicesEquipo.addEquipo(equipo);
        textExporter = new TextExporter();
        /* Para asociar Elementos */
        asociarElemento(id, torre, pantalla, mouse, teclado);
        /* Para Registrar Novedades */
        generarNovedad(id, torre, pantalla, mouse, teclado, responsable, equipo);
        this.equipos = null;
    }

    private void asociarElemento(int id, int torre, int pantalla, int mouse, int teclado)
            throws HistorialEquiposException {
        /* Para asociar Elementos */
        ServicesElemento servicesElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesElemento();
        servicesElemento.actualizarEquipoAsociado(torre, id);
        servicesElemento.actualizarEquipoAsociado(pantalla, id);
        servicesElemento.actualizarEquipoAsociado(mouse, id);
        servicesElemento.actualizarEquipoAsociado(teclado, id);
    }

    private void generarNovedad(int id, int torre, int pantalla, int mouse, int teclado, int responsable, Equipo equipo)
            throws HistorialEquiposException {
        /* Para Registrar Novedades */
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, torre, null, "Elemento Nuevo Registrado",
                "Se registro un nuevo elemento de tipo torre al equipo " + equipo.getNombre()));
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, pantalla, null, "Elemento Nuevo Registrado",
                "Se registro un nuevo elemento de tipo pantalla al equipo " + equipo.getNombre()));
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, mouse, null, "Elemento Nuevo Registrado",
                "Se registro un nuevo elemento de tipo mouse al equipo " + equipo.getNombre()));
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, id, teclado, null, "Elemento Nuevo Registrado",
                "Se registro un nuevo elemento de tipo teclado al equipo " + equipo.getNombre()));
    }

    public void darDeBajaEquipo(int id, String torreE, String mouseE, String pantallaE, String tecladoE,
            int responsable) throws HistorialEquiposException {
        servicesEquipo.darDeBajaEquipo(id, false);
        servicesEquipo.asociarLaboratorio(0, id);

        ServicesElemento servicesElemento = ServicesHistorialDeEquipoFactory.getInstance().getServicesElemento();
        servicesElemento.eliminarElementos(id, torreE, mouseE, pantallaE, tecladoE, responsable);

        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        Novedad novedad = new Novedad(1, responsable, id, 0, null, "Equipo Dado de baja",
                "El equipo fue dado de baja.");
        servicesNovedad.registrarNovedad(novedad);
        this.equipos = null;
    }

    public String consultarNombreEquipo(int id) throws HistorialEquiposException {
        Equipo equipo = servicesEquipo.consultarEquipoId(id);
        return equipo.getNombre();
    }

    public void asociarLaboratorio(int laboratorio, int equipoInt, int responsable) throws HistorialEquiposException {
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        Equipo equipo = servicesEquipo.consultarEquipoId(equipoInt);
        if (equipo.getLaboratorioObj().getId() != 0 && laboratorio != 0) {
            /* Generar Novedad de cambio */
            Novedad novedad = new Novedad(1, responsable, equipoInt, 0, null, "Equipo cambiado de laboratorio",
                    "El equipo fue cambiado de laboratorio a uno nuevo.");
            servicesNovedad.registrarNovedad(novedad);
        } else if (equipo.getLaboratorioObj().getId() != 0 && laboratorio == 0) {
            Novedad novedad = new Novedad(1, responsable, equipoInt, 0, null, "Equipo desasociado de laboratorio",
                    "El equipo fue desasociado del laboratorio.");
            servicesNovedad.registrarNovedad(novedad);
        } else {
            Novedad novedad = new Novedad(1, responsable, equipoInt, 0, null, "Equipo agregado a nuevo Laboratorio",
                    "El equipo fue agregado a un nuevo laboratorio.");
            servicesNovedad.registrarNovedad(novedad);
        }
        servicesEquipo.asociarLaboratorio(laboratorio, equipoInt);
        this.equipos = null;
    }

    public void desasociarEquiposLab(int id, int responsable) throws HistorialEquiposException {
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) servicesEquipo.consultarEquiposLab(id);
        for (Equipo equipo : equipos) {
            this.asociarLaboratorio(0, equipo.getId(), responsable);
        }
        this.equipos = null;
    }

    public void actualizarEquipo(Equipo equipo, String nombre, int laboratorio, String estado, int responsable)
            throws HistorialEquiposException {
        if (!nombre.equalsIgnoreCase(equipo.getNombre()) && !nombre.isEmpty()) {
            servicesEquipo.cambiarNombre(nombre, equipo.getId());
        }
        if (laboratorio != equipo.getLaboratorioObj().getId() && laboratorio != 0) {
            this.asociarLaboratorio(laboratorio, equipo.getId(), responsable);
        }
        if (estado.equalsIgnoreCase("Activo") || estado.equalsIgnoreCase("Inactivo")) {
            servicesEquipo.cambiarEstado(estado.equalsIgnoreCase("Activo"), equipo.getId());
        }
        Equipo equipoTemp = servicesEquipo.consultarEquipoId(equipo.getId());
        this.equiposSeleccionados.set(0, equipoTemp);
        this.equipos = null;
    }

    public void desasociarEquiposMultiple(ArrayList<Equipo> equiposDel, int responsable)
            throws HistorialEquiposException {
        for (Equipo equipo : equiposDel) {
            this.darDeBajaEquipo(equipo.getId(), "", "", "", "", responsable);
        }
        this.equipos = null;
    }

    public String consultarNombreElemento(int idEquipo, String tipoElemento) throws HistorialEquiposException {
        ArrayList<Elemento> elementosEquipo = (ArrayList<Elemento>) servicesElemento.consultarElementosEquipo(idEquipo);
        for (Elemento elemento : elementosEquipo) {
            if (elemento.getTipoElemento().getNombre().equals(tipoElemento)) {
                return elemento.getNombre();
            }
        }
        return servicesElemento.consultarElementoId(0).getNombre();
    }

    /* Getter and Setter */
    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    private int consultarNextId() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = consultarEquiposObj();
        int maxInt = 0;
        for (Equipo equipo : equipos) {
            if (equipo.getId() > maxInt) {
                maxInt = equipo.getId();
            }
        }
        return maxInt;
    }

    /* Crear Objeto Interno */
    public Map<String, Integer> getEquipoMap() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = consultarEquiposObj();
        Map<String, Integer> equipoMap = new LinkedHashMap<String, Integer>();
        for (Equipo equipo : equipos) {
            equipoMap.put(equipo.getNombre(), equipo.getId());
        }
        return equipoMap;
    }

    public Map<String, Integer> getEquipoMapActivo() throws HistorialEquiposException {
        ArrayList<Equipo> equipos = consultarEquiposObj();
        Map<String, Integer> equipoMap = new LinkedHashMap<String, Integer>();
        for (Equipo equipo : equipos) {
            if (equipo.getActivo()) {
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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ArrayList<Equipo> getEquiposSeleccionados() throws HistorialEquiposException {
        if (equiposSeleccionados == null || equiposSeleccionados.size() == 0 || equiposSeleccionados.get(0) == null) {
            equiposSeleccionados = new ArrayList<>();
            equiposSeleccionados.add(servicesEquipo.consultarEquipoId(1));
        }
        return equiposSeleccionados;
    }

    public void setEquiposSeleccionados(ArrayList<Equipo> equiposSeleccionados) {
        this.equiposSeleccionados = equiposSeleccionados;
    }

    public Exporter<DataTable> getTextExporter() {
        return textExporter;
    }

    public void setTextExporter(Exporter<DataTable> textExporter) {
        this.textExporter = textExporter;
    }
}
