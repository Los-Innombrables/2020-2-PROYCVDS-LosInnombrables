package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.ServicesLaboratorio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "laboratorioBean")
@SessionScoped

public class LaboratorioBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesLaboratorio servicesLaboratorio;

    public List<Laboratorio> consultarLaboratorios(){ return servicesLaboratorio.consultarLaboratorios();}
}
