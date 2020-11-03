package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesElemento;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesNovedad;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    private Map<String, Integer> elementoMapTorre;
    private String selectedElementoTorre;

    private Map<String, Integer> elementoMapPantalla;
    private String selectedElementoPantalla;

    private Map<String, Integer> elementoMapMouse;
    private String selectedElementoMouse;

    private Map<String, Integer> elementoMapTeclado;
    private String selectedElementoTeclado;

    private String selectedElemento;

    private String tipoEstado;

    private String message;


    @Inject
    private ServicesElemento servicesElemento;

    public ArrayList<Elemento> consultarElementos() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = (ArrayList<Elemento>) servicesElemento.consultarElementos();
        return  elementos;
    }

    public void makeElementoMap() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = consultarElementos();
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
        try{
            Elemento elemento;
            boolean activo = false;
            if (activoS.equalsIgnoreCase("Activo")){
                activo = true;
            }
            elemento = new Elemento(0, tipo, equipo, marca, referencia, new SimpleDateFormat("YYYY/MM/DD").parse("2020/09/28"), activo);
            servicesElemento.addElemento(elemento);
            this.saveMessage("Ingreso de elemento logrado !", "Aceptado");
        }catch (Exception e){
            this.saveMessage("Ingreso de elemento no valido !", "Error");
        }
    }

    public void asociarElemento(int equipo, int elemento, int responsable) throws HistorialEquiposException, ParseException {
        ArrayList<Elemento> elementos = (ArrayList<Elemento>) servicesElemento.consultarElementosEquipo(equipo);
        Elemento elementoS = servicesElemento.consultarElementoId(elemento);
        String tipo = elementoS.getTipo();
        for (Elemento e : elementos){
            if (e.getTipo().equalsIgnoreCase(tipo)){
                servicesElemento.actualizarEquipoAsociado(e.getId(), 0);
            }
        }
        servicesElemento.actualizarEquipoAsociado(elemento, equipo);
        ServicesNovedad servicesNovedad = ServicesHistorialDeEquipoFactory.getInstance().getServicesNovedad();
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, equipo, elemento,
                new SimpleDateFormat("YYYY/MM/DD").parse("2020/09/28"), "Cambio de elementos", "Se realizo el cmabio del elemento " + elementoS.getNombre()));
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
        context.addMessage(null, new FacesMessage(value,  message) );
    }

    public Map<String, Integer> getElementoMap() throws HistorialEquiposException {
        ArrayList<Elemento> elementos = this.consultarElementos();
        Map<String, Integer> elementoMap = new LinkedHashMap<String,Integer>();
        for(Elemento elemento : elementos){
            if(elemento.getEquipo() == 0){
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

}
