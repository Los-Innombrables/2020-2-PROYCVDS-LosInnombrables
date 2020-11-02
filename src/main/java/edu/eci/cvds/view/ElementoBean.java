package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesElemento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name = "elementoBean")
@SessionScoped

public class ElementoBean extends BasePageBean{
    private static final long serialVersionUID = 1L;

    private List<Elemento> elementos = new ArrayList<>();

    private Map<String, Integer> elementoMapTorre;
    private String selectedElementoTorre;

    private Map<String, Integer> elementoMapPantalla;
    private String selectedElementoPantalla;

    private Map<String, Integer> elementoMapMouse;
    private String selectedElementoMouse;

    private Map<String, Integer> elementoMapTeclado;
    private String selectedElementoTeclado;

    private String tipoEstado;

    @Inject
    private ServicesElemento servicesElemento;

    public List<Elemento> consultarElementos() throws HistorialEquiposException {
        elementos = servicesElemento.consultarElementos();
        return  elementos;
    }

    public void makeElementoMap() throws HistorialEquiposException {
        consultarElementos();
        elementoMapTorre = new LinkedHashMap<String,Integer>();
        elementoMapPantalla = new LinkedHashMap<String,Integer>();
        elementoMapMouse = new LinkedHashMap<String,Integer>();
        elementoMapTeclado = new LinkedHashMap<String,Integer>();
        for(Elemento elemento : elementos){
            String tipoElemento = elemento.getTipo();
            if (elemento.getEquipo() == 0) {
                if (tipoElemento.equalsIgnoreCase("Torre")) {
                    elementoMapTorre.put(elemento.getNombre(), elemento.getId());
                } else if (tipoElemento.equalsIgnoreCase("Pantalla")) {
                    elementoMapPantalla.put(elemento.getNombre(), elemento.getId());
                } else if (tipoElemento.equalsIgnoreCase("Mouse")) {
                    elementoMapMouse.put(elemento.getNombre(), elemento.getId());
                } else {
                    elementoMapTeclado.put(elemento.getNombre(), elemento.getId());
                }
            }
        }
    }

    public void actualizarEquipoAsociado(int id, int equipo) throws HistorialEquiposException {
        servicesElemento.actualizarEquipoAsociado(id , equipo);
    }

    public void addElemento(String tipo, int equipo, String marca, String referencia, String activoS) throws ParseException, HistorialEquiposException {
        Elemento elemento;
        boolean activo = false;
        if (activoS.equalsIgnoreCase("Activo")){
            activo = true;
        }
        elemento = new Elemento(0, tipo, equipo, marca, referencia, new SimpleDateFormat("YYYY/MM/DD").parse("2020/09/28"), activo);
        servicesElemento.addElemento(elemento);
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
}
