package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.services.ServicesElemento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "elementoBean")
@SessionScoped

public class ElementoBean extends BasePageBean{
    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesElemento servicesElemento;

    public List<Elemento> consultarElementos(){ return servicesElemento.consultarElementos(); }
}
