package edu.eci.cvds.services;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface ServicesNovedad {

    List<Novedad> consultarNovedadesObj() throws HistorialEquiposException;

    void registrarNovedad(Novedad novedad) throws HistorialEquiposException;

}
