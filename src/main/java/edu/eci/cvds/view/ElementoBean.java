package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesNovedad;

@SuppressWarnings("deprecation")
@ManagedBean(name = "elementoBean")
@SessionScoped

public class ElementoBean extends BasePageBean {
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> elementoMapTorre;
    private String selectedElementoTorre;

    private Map<String, Integer> elementoMapPantalla;
    private String selectedElementoPantalla;

    private Map<String, Integer> elementoMapMouse;
    private String selectedElementoMouse;

    private Map<String, Integer> elementoMapTeclado;
    private String selectedElementoTeclado;

    private ArrayList<Elemento> elementos;
    private ArrayList<Elemento> elementosSeleccionados;

    private String selectedElemento;

    private String selectedElementoAct;

    private String selectedElementoFull;

    private String tipoEstado;

    private String message;

    @Inject
    private ServicesElemento servicesElemento;

    public ArrayList<Elemento> consultarElementosObj() throws HistorialEquiposException {
        if (elementos == null) {
            elementos = (ArrayList<Elemento>) servicesElemento.consultarElementosObj();
        }
        return elementos;
    }

    public void makeElementoMap() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = consultarElementosObj();
        elementoMapTorre = new LinkedHashMap<String, Integer>();
        elementoMapPantalla = new LinkedHashMap<String, Integer>();
        elementoMapMouse = new LinkedHashMap<String, Integer>();
        elementoMapTeclado = new LinkedHashMap<String, Integer>();
        for (Elemento elemento : elementos) {
            TipoElemento tipoElemento = elemento.getTipoElemento();
            if (elemento.getEquipoOb().getId() == 0 && elemento.isActivo()) {
                if (tipoElemento.getNombre().equalsIgnoreCase("Torre")) {
                    elementoMapTorre.put(elemento.getNombre(), elemento.getId());
                } else if (tipoElemento.getNombre().equalsIgnoreCase("Pantalla")) {
                    elementoMapPantalla.put(elemento.getNombre(), elemento.getId());
                } else if (tipoElemento.getNombre().equalsIgnoreCase("Mouse")) {
                    elementoMapMouse.put(elemento.getNombre(), elemento.getId());
                } else {
                    elementoMapTeclado.put(elemento.getNombre(), elemento.getId());
                }
            }
        }
    }

    public void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException {
        servicesElemento.actualizarEquipoAsociado(id, equipo);
        this.elementos = null;
    }

    public void addElemento(String tipo, int equipo, String marca, String referencia, String activoS)
            throws HistorialEquiposException {
        Elemento elemento;
        boolean activo = false;
        if (activoS.equalsIgnoreCase("Activo")) {
            activo = true;
        }
        elemento = new Elemento(0, tipo, equipo, marca, referencia, null, activo);
        servicesElemento.addElemento(elemento);
        this.elementos = null;
    }

    public void asociarElemento(int equipo, int elemento, int responsable) throws HistorialEquiposException {
        ArrayList<Elemento> elementos = (ArrayList<Elemento>) servicesElemento.consultarElementosEquipo(equipo);
        Elemento elementoS = servicesElemento.consultarElementoId(elemento);
        String tipo = elementoS.getTipoElemento().getNombre();
        for (Elemento e : elementos) {
            if (e.getTipoElemento().getNombre().equalsIgnoreCase(tipo)) {
                servicesElemento.actualizarEquipoAsociado(e.getId(), 0);
            }
        }
        servicesElemento.actualizarEquipoAsociado(elemento, equipo);
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, equipo, elemento, null, "Cambio de elementos",
                "Se realizo el cambio del elemento " + elementoS.getNombre()));
        this.elementos = null;
    }

    public int getEquipoId(int id) throws HistorialEquiposException {
        Elemento elemento = servicesElemento.consultarElementoId(id);
        return elemento.getEquipo();
    }

    public void darDeBajaElemento(int id, int responsable) throws HistorialEquiposException {
        servicesElemento.actualizarEstado(id, false);
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, 0, id, null, "Elemento Dado de baja",
                "Se dio de baja al elemento con identificador " + id));
        this.elementos = null;
    }

    public void darDeBajaElementos(ArrayList<Elemento> elementosElim, int responsable)
            throws HistorialEquiposException {
        for (Elemento e : elementosElim) {
            darDeBajaElemento(e.getId(), responsable);
        }
        this.elementos = null;
    }

    public void actualizarElemento(Elemento elementoAct, String nombre, int equipo, String estado) {

    }

    /*-------------Getter-Setter-------------*/
    public Map<String, Integer> getElementoMapTorre() throws HistorialEquiposException {
        this.makeElementoMap();
        return elementoMapTorre;
    }

    public void setElementoMapTorre(Map<String, Integer> elementoMapTorre) {
        this.elementoMapTorre = elementoMapTorre;
    }

    public String getSelectedElementoTorre() {
        return selectedElementoTorre;
    }

    public void setSelectedElementoTorre(String selectedElementoTorre) {
        this.selectedElementoTorre = selectedElementoTorre;
    }

    public Map<String, Integer> getElementoMapPantalla() {
        return elementoMapPantalla;
    }

    public void setElementoMapPantalla(Map<String, Integer> elementoMapPantalla) {
        this.elementoMapPantalla = elementoMapPantalla;
    }

    public String getSelectedElementoPantalla() {
        return selectedElementoPantalla;
    }

    public void setSelectedElementoPantalla(String selectedElementoPantalla) {
        this.selectedElementoPantalla = selectedElementoPantalla;
    }

    public Map<String, Integer> getElementoMapMouse() {
        return elementoMapMouse;
    }

    public void setElementoMapMouse(Map<String, Integer> elementoMapMouse) {
        this.elementoMapMouse = elementoMapMouse;
    }

    public String getSelectedElementoMouse() {
        return selectedElementoMouse;
    }

    public void setSelectedElementoMouse(String selectedElementoMouse) {
        this.selectedElementoMouse = selectedElementoMouse;
    }

    public Map<String, Integer> getElementoMapTeclado() {
        return elementoMapTeclado;
    }

    public void setElementoMapTeclado(Map<String, Integer> elementoMapTeclado) {
        this.elementoMapTeclado = elementoMapTeclado;
    }

    public String getSelectedElementoTeclado() {
        return selectedElementoTeclado;
    }

    public void setSelectedElementoTeclado(String selectedElementoTeclado) {
        this.selectedElementoTeclado = selectedElementoTeclado;
    }

    public ServicesElemento getServicesElemento() {
        return servicesElemento;
    }

    public void setServicesElemento(ServicesElemento servicesElemento) {
        this.servicesElemento = servicesElemento;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void saveMessage(String message, String value) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(value, message));
    }

    public Map<String, Integer> getElementoMap() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = this.consultarElementosObj();
        Map<String, Integer> elementoMap = new LinkedHashMap<String, Integer>();
        for (Elemento elemento : elementos) {
            if (elemento.getEquipoOb().getId() == 0) {
                elementoMap.put(elemento.getNombre(), elemento.getId());
            }
        }
        return elementoMap;
    }

    public Map<String, Integer> getElementoMapFull() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = this.consultarElementosObj();
        Map<String, Integer> elementoMap = new LinkedHashMap<String, Integer>();
        for (Elemento elemento : elementos) {
            elementoMap.put(elemento.getNombre(), elemento.getId());
        }
        return elementoMap;
    }

    public Map<String, Integer> getElementoMapAct() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = this.consultarElementosObj();
        Map<String, Integer> elementoMap = new LinkedHashMap<String, Integer>();
        for (Elemento elemento : elementos) {
            if (elemento.getEquipoOb().getId() == 0 && elemento.isActivo()) {
                elementoMap.put(elemento.getNombre(), elemento.getId());
            }
        }
        return elementoMap;
    }

    public String getSelectedElemento() {
        return selectedElemento;
    }

    public void setSelectedElemento(String selectedElemento) {
        this.selectedElemento = selectedElemento;
    }

    public String getSelectedElementoFull() {
        return selectedElementoFull;
    }

    public void setSelectedElementoFull(String selectedElementoFull) {
        this.selectedElementoFull = selectedElementoFull;
    }

    public String getSelectedElementoAct() {
        return selectedElementoAct;
    }

    public void setSelectedElementoAct(String selectedElementoAct) {
        this.selectedElementoAct = selectedElementoAct;
    }

    public ArrayList<Elemento> getElementosSeleccionados() {
        return elementosSeleccionados;
    }

    public void setElementosSeleccionados(ArrayList<Elemento> elementosSeleccionados) {
        this.elementosSeleccionados = elementosSeleccionados;
    }
}
