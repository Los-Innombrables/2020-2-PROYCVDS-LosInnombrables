package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;
import edu.eci.cvds.exceptions.PersistenceException;

import java.util.List;

public interface EquipoDAO {

    void addEquipo(Equipo equipo) throws HistorialEquiposException;

    List<Equipo> consultarEquipos() throws HistorialEquiposException;

    void darDeBajaEquipo(int id, boolean activo) throws HistorialEquiposException;

    Equipo consultarEquipoId(int id) throws HistorialEquiposException;

    void asociarLaboratorio(int laboratorio, int id) throws HistorialEquiposException;

}
