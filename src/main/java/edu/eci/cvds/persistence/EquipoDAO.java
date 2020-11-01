package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.PersistenceException;

import java.util.List;

public interface EquipoDAO {

    void addEquipo(Equipo equipo) throws PersistenceException;

    List<Equipo> consultarEquipos() throws PersistenceException;

}
