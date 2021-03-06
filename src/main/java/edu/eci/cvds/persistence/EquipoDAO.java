package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.exceptions.HistorialEquiposException;

import java.util.List;

public interface EquipoDAO {

    void addEquipo(Equipo equipo) throws HistorialEquiposException;

    List<Equipo> consultarEquiposObj() throws HistorialEquiposException;

    void darDeBajaEquipo(int id, boolean activo) throws HistorialEquiposException;

    Equipo consultarEquipoId(int id) throws HistorialEquiposException;

    void asociarLaboratorio(int laboratorio, int id) throws HistorialEquiposException;

    List<Equipo> consultarEquiposLab(int id) throws HistorialEquiposException;

    void cambiarNombre(String nombre, int id) throws HistorialEquiposException;

    void cambiarEstado(boolean activo, int id) throws HistorialEquiposException;

}
