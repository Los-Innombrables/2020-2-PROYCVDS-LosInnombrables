package edu.eci.cvds.services;

import edu.eci.cvds.entities.Equipo;

import java.util.List;

public interface ServicesEquipo {

    void addEquipo(Equipo equipo);

    List<Equipo> consultarEquipos();
}
