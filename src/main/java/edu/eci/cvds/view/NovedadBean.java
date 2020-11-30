package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.services.ServicesNovedad;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "novedadBean")
@SessionScoped

public class NovedadBean extends BasePageBean {

    private static final long serialVersionUID = 1L;
    private Novedad novedad;

    /* Exportar */

    private Exporter<DataTable> textExporter = new TextExporter();

    @Inject
    private ServicesNovedad servicesNovedad;

    public List<Novedad> consultarNovedadesObj() throws HistorialEquiposException {
        return servicesNovedad.consultarNovedadesObj();
    }

    public List<Novedad> consultarNovedadesEquipo(int id) throws HistorialEquiposException {
        return servicesNovedad.consultarNovedadesEquipo(id);
    }

    public List<Novedad> consultarNovedadesElemento(int id) throws HistorialEquiposException {
        return servicesNovedad.consultarNovedadesElemento(id);
    }

    public void registrarNovedad(int responsable, int equipo, int elemento, String titulo, String novedad)
            throws HistorialEquiposException {
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, equipo, elemento, null, titulo, novedad));
    }

    public void registrarNovedadEquipo(int responsable, int equipo, String titulo, String novedad)
            throws HistorialEquiposException {
        servicesNovedad.registrarNovedad(new Novedad(1, responsable, equipo, 0, null, titulo, novedad));
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public Exporter<DataTable> getTextExporter() {
        return textExporter;
    }

    public void setTextExporter(Exporter<DataTable> textExporter) {
        this.textExporter = textExporter;
    }
}
