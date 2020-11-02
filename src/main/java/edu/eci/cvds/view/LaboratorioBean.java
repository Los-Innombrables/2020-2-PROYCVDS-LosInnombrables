package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.ServicesLaboratorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratorioBean")
@SessionScoped

public class LaboratorioBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    private List<Laboratorio> laboratorios = new ArrayList<>();
    private Map<String, Integer> laboratorioMap;
    private String selectedLab;

    @Inject
    private ServicesLaboratorio servicesLaboratorio;

    public List<Laboratorio> consultarLaboratorios(){
        laboratorios = servicesLaboratorio.consultarLaboratorios();
        return laboratorios;
    }

    public Map<String, Integer> consultarNombreLaboratorios(){
        consultarLaboratorios();
        laboratorioMap = new LinkedHashMap<String,Integer>();
        for(Laboratorio l : laboratorios){
            laboratorioMap.put(l.getNombre(), l.getId());
        }
        return laboratorioMap;
    }

    public Laboratorio consultarLaboratorioNombre(String nombre){
        return servicesLaboratorio.consultarLaboratorioNombre(nombre);
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

}
