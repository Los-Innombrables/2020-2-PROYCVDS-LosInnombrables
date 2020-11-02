package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.TipoElemento;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesTipoElemento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "tipoElementoBean")
@SessionScoped

public class TipoElementoBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesTipoElemento servicesTipoElemento;

    public List<TipoElemento> consultarTipoElemento() throws HistorialEquiposException {
        return servicesTipoElemento.consultarTipoElemento();
    }

}
