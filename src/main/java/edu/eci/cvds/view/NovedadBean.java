package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesNovedad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedadBean")
@SessionScoped

public class NovedadBean extends BasePageBean{

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicesNovedad servicesNovedad;

    public List<Novedad> consultarNovedades() throws HistorialEquiposException {
        return servicesNovedad.consultarNovedades();
    }

    public void registrarNovedad(int responsable, int equipo, int elemento, String titulo, String novedad) throws HistorialEquiposException {
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, equipo, elemento, null, titulo, novedad));
    }

    public void registrarNovedadEquipo(int responsable, int equipo, String titulo, String novedad) throws HistorialEquiposException {
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, equipo, 0, null, titulo, novedad));
    }

}
