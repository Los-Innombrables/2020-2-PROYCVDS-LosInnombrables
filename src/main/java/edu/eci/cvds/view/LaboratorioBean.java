package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesEquipo;
import edu.eci.cvds.services.ServicesHistorialDeEquipoFactory;
import edu.eci.cvds.services.ServicesLaboratorio;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratorioBean")
@SessionScoped

public class LaboratorioBean extends BasePageBean{

    private static final long serialVersionUID = 1L;
    private String tipoEstado;

    private Map<String, Integer> laboratorioMap;
    private String selectedLab;

    private Laboratorio laboratorio;
    private ArrayList<Laboratorio> laboratoriosSeleccionados;
    private ArrayList<Laboratorio> laboratoriosFiltro;

    /*Exportar*/

    private Exporter<DataTable> textExporter = new TextExporter();

    @Inject
    private ServicesLaboratorio servicesLaboratorio;

    private ArrayList<Laboratorio> laboratorios;

    public ArrayList<Laboratorio> consultarLaboratorios() throws HistorialEquiposException {
        if (this.laboratorios == null){
            this.laboratorios = (ArrayList<Laboratorio>) servicesLaboratorio.consultarLaboratorios();
        }
        return this.laboratorios;
    }

    public Map<String, Integer> consultarNombreLaboratorios() throws HistorialEquiposException {
        this.laboratorios = null;
        ArrayList<Laboratorio> laboratoriosL = consultarLaboratorios();
        laboratorioMap = new LinkedHashMap<String,Integer>();
        for(Laboratorio l : laboratoriosL){
            if(l.getActivo()){
                laboratorioMap.put(l.getNombre(), l.getId());
            }
        }
        return laboratorioMap;
    }

    public Laboratorio consultarLaboratorioNombre(String nombre) throws HistorialEquiposException {
        return servicesLaboratorio.consultarLaboratorioNombre(nombre);
    }

    public void addLaboratorio(String nombre, String estado) throws HistorialEquiposException {
        boolean activo = false;
        if (estado.equalsIgnoreCase("Activo")){
            activo = true;
        }
        Laboratorio laboratorio = new Laboratorio(0, nombre, null, activo, null, 0);
        servicesLaboratorio.addLaboratorio(laboratorio);
        textExporter = new TextExporter();
        this.laboratorios = null;
    }

    public void cerrarLaboratorio(int id) throws HistorialEquiposException {
        servicesLaboratorio.cerrarLaboratorio(id);
        this.laboratorios = null;
    }

    public void cerrarLaboratorios(ArrayList<Laboratorio> laboratoriosL) throws HistorialEquiposException{
        for(Laboratorio laboratorio : laboratoriosL){
            this.cerrarLaboratorio(laboratorio.getId());
        }
        this.laboratorios = null;
    }

    public void actualizarLaboratorio(Laboratorio laboratorio, String nombre, String estado) throws HistorialEquiposException {
        if(!nombre.equalsIgnoreCase(laboratorio.getNombre()) && !nombre.isEmpty()){
            servicesLaboratorio.actualizarNombre(laboratorio.getId(), nombre);
        }
        if (estado.equalsIgnoreCase("Activo") && !laboratorio.getActivo()){
            servicesLaboratorio.abrirLaboratorio(laboratorio.getId());
        }
        if (estado.equalsIgnoreCase("Inactivo") && laboratorio.getActivo()){
            servicesLaboratorio.cerrarLaboratorio(laboratorio.getId());
        }
        String nombreSearch = nombre.isEmpty() ? laboratorio.getNombre() : nombre;
        Laboratorio laboratorioTemp = servicesLaboratorio.consultarLaboratorioNombre(nombreSearch);
        this.laboratoriosSeleccionados.set(0, laboratorioTemp);
        this.laboratorios = null;
    }

    public Map<String, Integer> getLaboratorioMap() {
        return laboratorioMap;
    }

    public void setLaboratorioMap(Map<String, Integer> laboratorioMap) {
        this.laboratorioMap = laboratorioMap;
    }

    public String getSelectedLab() {
        return selectedLab;
    }

    public void setSelectedLab(String selectedLab) {
        this.selectedLab = selectedLab;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public ArrayList<Laboratorio> getLaboratoriosSeleccionados() {
        return laboratoriosSeleccionados;
    }

    public void setLaboratoriosSeleccionados(ArrayList<Laboratorio> laboratoriosSeleccionados) { this.laboratoriosSeleccionados = laboratoriosSeleccionados; }

    public ArrayList<Laboratorio> getLaboratoriosFiltro() throws HistorialEquiposException { return laboratoriosFiltro; }

    public void setLaboratoriosFiltro(ArrayList<Laboratorio> laboratoriosFiltro) { this.laboratoriosFiltro = laboratoriosFiltro; }

    public ArrayList<Laboratorio> getLaboratorios() throws HistorialEquiposException { return this.consultarLaboratorios(); }

    public void setLaboratorios(ArrayList<Laboratorio> laboratorios) { this.laboratorios = laboratorios; }

    public String getTipoEstado() { return tipoEstado; }

    public void setTipoEstado(String tipoEstado) { this.tipoEstado = tipoEstado; }
    public Exporter<DataTable> getTextExporter() {
        return textExporter;
    }

    public void setTextExporter(Exporter<DataTable> textExporter) {
        this.textExporter = textExporter;}
}
