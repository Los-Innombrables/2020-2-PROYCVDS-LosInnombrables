package edu.eci.cvds.services;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ServicesEquipo {

    void addEquipo(Equipo equipo) throws HistorialEquiposException;

    List<Equipo> consultarEquipos() throws HistorialEquiposException;
}
