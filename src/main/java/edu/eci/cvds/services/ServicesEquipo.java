package edu.eci.cvds.services;

import java.util.List;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;

public interface ServicesEquipo {

    void addEquipo(Equipo equipo) throws HistorialEquiposException;

    List<Equipo> consultarEquiposObj() throws HistorialEquiposException;

    void darDeBajaEquipo(int id, boolean activo) throws HistorialEquiposException;

    Equipo consultarEquipoId(int id) throws HistorialEquiposException;

    void asociarLaboratorio(int laboratorio, int id) throws HistorialEquiposException;

    List<Equipo> consultarEquiposLab(int id) throws HistorialEquiposException;

    void cambiarNombre(String nombre, int id) throws HistorialEquiposException;

    void cambiarEstado(boolean activo, int id) throws HistorialEquiposException;
}
