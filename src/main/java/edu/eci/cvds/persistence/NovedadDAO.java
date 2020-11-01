package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface NovedadDAO {

    List<Novedad> consultarNovedades() throws HistorialEquiposException;

}
