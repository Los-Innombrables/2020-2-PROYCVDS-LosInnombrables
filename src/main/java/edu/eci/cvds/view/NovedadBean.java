package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.services.ServicesNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedadBean")
@SessionScoped

public class NovedadBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesNovedad servicesNovedad;

    public List<Novedad> consultarNovedades(){ return servicesNovedad.consultarNovedades();}

}
