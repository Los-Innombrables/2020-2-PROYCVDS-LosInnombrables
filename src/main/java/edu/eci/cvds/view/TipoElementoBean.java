package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesTipoElemento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@ManagedBean(name = "tipoElementoBean")
@SessionScoped

public class TipoElementoBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    private Map<String, String> tipoElementoMap;
    private String selectedTipoElemento;

    private List<TipoElemento> tipoElementos = new ArrayList<>();

    @Inject
    private ServicesTipoElemento servicesTipoElemento;

    public List<TipoElemento> consultarTipoElemento() throws HistorialEquiposException {
        tipoElementos = servicesTipoElemento.consultarTipoElemento();
        return tipoElementos;
    }

    public Map<String, String> getTipoElementoMap() throws HistorialEquiposException {
        consultarTipoElemento();
        tipoElementoMap = new LinkedHashMap<String,String>();
        for(TipoElemento tipoElemento : tipoElementos){
            tipoElementoMap.put(tipoElemento.getNombre(), tipoElemento.getNombre());
        }
        return tipoElementoMap;
    }

    public void setTipoElementoMap(Map<String, String> tipoElementoMap) {
        this.tipoElementoMap = tipoElementoMap;
    }

    public String getSelectedTipoElemento() {
        return selectedTipoElemento;
    }

    public void setSelectedTipoElemento(String selectedTipoElemento) {
        this.selectedTipoElemento = selectedTipoElemento;
    }
}
